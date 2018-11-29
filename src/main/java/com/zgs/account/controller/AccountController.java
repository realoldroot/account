package com.zgs.account.controller;

import com.zgs.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhengenshen
 * @date 2018-11-29 14:20
 */
@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;
}
