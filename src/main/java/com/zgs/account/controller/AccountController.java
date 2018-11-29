package com.zgs.account.controller;

import com.zgs.account.common.DataType;
import com.zgs.account.common.ParamType;
import com.zgs.account.model.ApiResponse;
import com.zgs.account.service.AccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhengenshen
 * @date 2018-11-29 14:20
 */
@Slf4j
@Api(tags = "0.1", description = "账户管理", value = "账户管理")
@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @ApiOperation(value = "条件查询（DONE）", notes = "备注")
    @ApiImplicitParams({@ApiImplicitParam(name = "username", value = "用户名", dataType = DataType.STRING,
            paramType = ParamType.QUERY, defaultValue = "xxx")})
    @GetMapping("/getByUserName")
    public ApiResponse getByUserName(String username) {
        val account = accountService.getByUserName(username);
        log.info("多个参数用  @ApiImplicitParams");
        return ApiResponse.ofSuccess(account);
    }
}
