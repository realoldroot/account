package com.zgs.account.dao;

import com.zgs.account.bean.base.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author zhengenshen
 * @date 2018-11-29 14:21
 */
@Repository
public interface AccountDao extends JpaRepository<Account,Long> {

}
