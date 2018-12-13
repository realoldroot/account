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
public interface AccountDao extends JpaRepository<Account, Long> {

    byte DISABLE = 0;
    byte ENABLE = 1;

    Optional<Account> getByUsername(String username);

    boolean existsByUsernameAndPhoneNumber(String username, String phoneNumber);

    boolean existsByPhoneNumber(String phoneNumber);

}
