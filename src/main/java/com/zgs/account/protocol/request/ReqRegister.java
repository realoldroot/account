package com.zgs.account.protocol.request;

import lombok.Getter;
import lombok.Setter;

/**
 * @author zhengenshen
 * @date 2018-12-13 15:14
 */
@Getter
@Setter
public class ReqRegister {

    private String username;
    private String password;
    private String phoneNumber;
    private String email;

    private String loginAddress;
    private byte loginType;
    private String loginDeviceName;
}
