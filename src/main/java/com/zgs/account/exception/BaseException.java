package com.zgs.account.exception;

import com.zgs.account.constant.Status;
import lombok.Data;

/**
 * 异常基类
 *
 * @author zhengenshen
 * @date 2018-11-29 16:05
 */
@Data
public class BaseException extends RuntimeException {

    private Integer code;
    private String message;

    public BaseException(Status status) {
        super(status.getMessage());
        this.code = status.getCode();
        this.message = status.getMessage();
    }

    public BaseException(Integer code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }
}
