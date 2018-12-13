package com.zgs.account.exception;

import com.zgs.account.constant.Status;

/**
 * @author zhengenshen
 * @date 2018-12-10 18:05
 */
public class UnauthorizedException extends BaseException {
    public UnauthorizedException(Status status) {
        super(status);
    }
}
