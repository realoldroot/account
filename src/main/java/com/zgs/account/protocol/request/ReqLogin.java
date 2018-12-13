package com.zgs.account.protocol.request;

import lombok.Getter;
import lombok.Setter;

/**
 * @author zhengenshen
 * @date 2018-12-13 12:15
 */
@Getter
@Setter
public class ReqLogin {
    private String username;
    private String password;
    private String loginAddress;
    private byte loginType;
    private String loginDeviceName;
}
