package com.zgs.account.service.impl;

import com.zgs.account.bean.Account;
import com.zgs.account.bean.Account.EAccountStatus;
import com.zgs.account.bean.AccountRecord.ELoginType;
import com.zgs.account.common.JWTUtil;
import com.zgs.account.common.PasswordHash;
import com.zgs.account.constant.Status;
import com.zgs.account.dao.AccountDao;
import com.zgs.account.exception.JsonException;
import com.zgs.account.protocol.request.ReqLogin;
import com.zgs.account.protocol.request.ReqRegister;
import com.zgs.account.protocol.response.RepLogin;
import com.zgs.account.protocol.response.RepRegister;
import com.zgs.account.service.AccountRecordService;
import com.zgs.account.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

/**
 * @author zhengenshen
 * @date 2018-11-29 14:22
 */
@Slf4j
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;
    @Autowired
    private AccountRecordService accountRecordService;

    @Override
    public Account getByUserName(String username) {
        return accountDao.getByUsername(username)
                .orElseThrow(() -> new JsonException(Status.UNKNOWN_ERROR.getCode(), "没有查询到用户"));
    }

    @Transactional
    @Override
    public RepLogin login(ReqLogin params) {
        Account account = getByUserName(params.getUsername());
        try {
            boolean isValid = PasswordHash.validatePassword(params.getPassword(),
                                                            account.getSalt(), account.getPassword());
        } catch (InvalidKeySpecException | NoSuchAlgorithmException e) {
            throw new JsonException(Status.UNKNOWN_ERROR.getCode(), "用户名或密码校验失败");
        }
        val loginTime = System.currentTimeMillis();
        account.setLastLoginTime(loginTime);
        accountDao.save(account);

        accountRecordService.saveLoginRecord(account.getId(),
                                             ELoginType.WEB,
                                             params.getLoginDeviceName(),
                                             params.getLoginAddress(), loginTime);
        val ret = new RepLogin();
        ret.setAccount(account);
        ret.setToken(JWTUtil.sign(account.getUsername(), account.getPassword()));
        return ret;
    }

    @Transactional
    @Override
    public RepRegister register(ReqRegister params) {
        if (accountDao.existsByUsernameAndPhoneNumber(params.getUsername(), params.getPhoneNumber())) {
            throw new JsonException(Status.UNKNOWN_ERROR.getCode(), "手机号已经存在");
        }
        String[] passwordArray;
        try {
            passwordArray = PasswordHash.createHash(params.getPassword());
        } catch (InvalidKeySpecException | NoSuchAlgorithmException e) {
            log.warn("创建密码失败");
            throw new JsonException(Status.UNKNOWN_ERROR.getCode(), "服务器错误");
        }
        val now = System.currentTimeMillis();
        Account account = new Account();
        account.setUsername(params.getUsername());
        account.setPassword(passwordArray[0]);
        account.setPhoneNumber(params.getPhoneNumber());
        account.setEmail(params.getEmail());
        account.setSalt(passwordArray[1]);
        account.setLastLoginTime(now);
        account.setStatus(EAccountStatus.ENABLE);
        account.setCreateTime(now);
        account.setLastLoginTime(now);
        accountDao.save(account);

        accountRecordService.saveLoginRecord(account.getId(),
                                             ELoginType.WEB,
                                             params.getLoginDeviceName(),
                                             params.getLoginAddress(), now);

        val ret = new RepRegister();
        ret.setAccount(account);
        ret.setToken(JWTUtil.sign(account.getUsername(), account.getPassword()));
        return ret;
    }
}
