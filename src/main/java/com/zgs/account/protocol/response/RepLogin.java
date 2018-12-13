package com.zgs.account.protocol.response;

import com.zgs.account.bean.Account;
import lombok.Getter;
import lombok.Setter;

/**
 * @author zhengenshen
 * @date 2018-12-13 15:13
 */
@Getter
@Setter
public class RepLogin {
    private Account account;
    private String token;
}
