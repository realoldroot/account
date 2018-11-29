package com.zgs.account.constant;

import lombok.Getter;

/**
 * @author zhengenshen
 * @date 2018-11-29 16:04
 */
@Getter
public enum Status {

    /**
     * 操作成功
     */
    OK(200, "操作成功"),

    /**
     * 未知异常
     */
    UNKNOWN_ERROR(500, "服务器出错啦");
    /**
     * 状态码
     */
    private Integer code;
    /**
     * 内容
     */
    private String message;

    Status(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
