package com.zgs.account.dao;

import com.zgs.account.bean.AccountRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author zhengenshen
 * @date 2018-12-13 14:21
 */
@Repository
public interface AccountRecordDao extends JpaRepository<AccountRecord, Long> {

}
