package com.zgs.account.bean;

import com.zgs.account.constant.EnumAccount.ELoginType;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author zhengenshen
 * @date 2018-12-13 14:16
 */
@Data
@Entity
@Table
public class AccountRecord implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 账户id
     */
    private Long accountId;

    /**
     * 登录地址
     */
    private String loginAddress;

    /**
     * 登录类型
     */
    @Enumerated(EnumType.ORDINAL)
    private ELoginType loginType;

    /**
     * 登录设备名称
     */
    private String loginDeviceName;

    /**
     * 创建时间
     */
    private long createTime;


}
