package com.zgs.account.exception;

import com.zgs.account.constant.Status;
import lombok.Getter;

/**
 * 页面异常
 *
 * @author zhengenshen
 * @date 2018-11-29 16:06
 */
@Getter
public class PageException extends BaseException {
    public PageException(Status status) {
        super(status);
    }

    public PageException(Integer code, String message) {
        super(code, message);
    }
}
