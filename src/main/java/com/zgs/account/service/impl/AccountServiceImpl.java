package com.zgs.account.service.impl;

import com.zgs.account.bean.Account;
import com.zgs.account.constant.Status;
import com.zgs.account.dao.AccountDao;
import com.zgs.account.exception.JsonException;
import com.zgs.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhengenshen
 * @date 2018-11-29 14:22
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public Account getByUserName(String username) {
        return accountDao.getByName(username)
                .orElseThrow(() -> new JsonException(Status.UNKNOWN_ERROR.getCode(), "没有查询到用户"));
    }
}
