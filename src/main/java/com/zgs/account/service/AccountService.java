package com.zgs.account.service;

import com.zgs.account.bean.Account;

/**
 * @author zhengenshen
 * @date 2018-11-29 14:22
 */
public interface AccountService {

    Account getByUserName(String username);
}
