package com.zgs.account.bean.base;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author zhengenshen
 * @date 2018-11-29 14:43
 */
// @MappedSuperclass
// @EntityListeners(AuditingEntityListener.class)
// @Data
public class AbstractAuditModel implements Serializable {

    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 创建时间
     */
    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createTime;

    /**
     * 上次更新时间
     */
    @Column(nullable = false)
    @UpdateTimestamp
    private LocalDateTime lastUpdateTime;
}
