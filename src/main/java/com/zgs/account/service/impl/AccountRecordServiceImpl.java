package com.zgs.account.service.impl;

import com.zgs.account.bean.AccountRecord;
import com.zgs.account.bean.AccountRecord.ELoginType;
import com.zgs.account.dao.AccountRecordDao;
import com.zgs.account.service.AccountRecordService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhengenshen
 * @date 2018-12-13 14:23
 */
@Service
public class AccountRecordServiceImpl implements AccountRecordService {

    @Autowired
    private AccountRecordDao accountRecordDao;

    @Override
    public void saveLoginRecord(long accountId, ELoginType loginType, String loginDeviceName, String loginAddress, long loginTime) {
        val ar = new AccountRecord();
        ar.setAccountId(accountId);
        ar.setLoginAddress(loginAddress);
        ar.setLoginType(loginType);
        ar.setLoginDeviceName(loginDeviceName);
        ar.setCreateTime(loginTime);
        accountRecordDao.save(ar);
    }
}
