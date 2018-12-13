package com.zgs.account.service;

import com.zgs.account.bean.AccountRecord.ELoginType;

/**
 * @author zhengenshen
 * @date 2018-12-13 14:23
 */
public interface AccountRecordService {

    /**
     * 保存登录记录
     *  @param accountId       账户id
     * @param loginType 登录设备类型
     * @param loginDeviceName 登录设备名称
     * @param loginAddress    登录地址
     * @param loginTime       登陆时间
     */
    void saveLoginRecord(long accountId, ELoginType loginType, String loginDeviceName, String loginAddress, long loginTime);
}
