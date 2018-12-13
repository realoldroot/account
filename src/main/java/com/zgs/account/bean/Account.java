package com.zgs.account.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;

/**
 * @author zhengenshen
 * @date 2018-11-29 14:45
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Account implements Serializable {

    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    @JsonIgnore
    private String password;

    /**
     * 盐
     */
    @JsonIgnore
    private String salt;

    @Enumerated(EnumType.ORDINAL)
    private ESex sex;

    /**
     * 邮箱
     */
    @Email
    private String email;

    /**
     * 手机号码
     */
    @Column(updatable = false)
    private String phoneNumber;

    /**
     * 状态，-1：逻辑删除，0：禁用，1：启用
     */
    @Enumerated(EnumType.ORDINAL)
    private EAccountStatus status;

    /**
     * 创建时间
     */
    private long createTime;
    /**
     * 上次登录时间
     */
    private long lastLoginTime;

    public enum ESex {
        MAN, WOMAN
    }

    @Getter
    public enum EAccountStatus {
        DISABLE, ENABLE
    }
}
