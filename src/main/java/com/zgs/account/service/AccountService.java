package com.zgs.account.service;

import com.zgs.account.bean.Account;
import com.zgs.account.protocol.request.ReqLogin;
import com.zgs.account.protocol.request.ReqRegister;
import com.zgs.account.protocol.response.RepLogin;
import com.zgs.account.protocol.response.RepRegister;

/**
 * @author zhengenshen
 * @date 2018-11-29 14:22
 */
public interface AccountService {

    Account getByUserName(String username);

    RepLogin login(ReqLogin params);

    RepRegister register(ReqRegister params);
}
