package com.zgs.account.controller;

import com.zgs.account.constant.Status;
import com.zgs.account.exception.JsonException;
import com.zgs.account.model.ApiResponse;
import com.zgs.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhengenshen
 * @date 2018-11-29 14:20
 */
@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/json")
    public ApiResponse jsonException() {
        throw new JsonException(Status.UNKNOWN_ERROR);
    }
}
