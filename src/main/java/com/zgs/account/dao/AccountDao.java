package com.zgs.account.dao;

import com.zgs.account.bean.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author zhengenshen
 * @date 2018-11-29 14:21
 */
@Repository
public interface AccountDao extends JpaRepository<Account,Long> {

    Optional<Account> getByName(String name);

}
