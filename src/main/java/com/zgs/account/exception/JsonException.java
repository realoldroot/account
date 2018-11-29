package com.zgs.account.exception;

import com.zgs.account.constant.Status;
import lombok.Getter;

/**
 * JSON 异常
 *
 * @author zhengenshen
 * @date 2018-11-29 16:06
 */
@Getter
public class JsonException extends BaseException {
    public JsonException(Status status) {
        super(status);
    }

    public JsonException(Integer code, String message) {
        super(code, message);
    }
}
