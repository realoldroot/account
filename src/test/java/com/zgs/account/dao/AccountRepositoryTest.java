package com.zgs.account.dao;

import cn.hutool.core.util.IdUtil;
import cn.hutool.crypto.SecureUtil;
import com.zgs.account.AccountApplicationTests;
import com.zgs.account.bean.Account;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author zhengenshen
 * @date 2018-11-29 14:47
 */
@Slf4j
public class AccountRepositoryTest extends AccountApplicationTests {

    @Autowired
    private AccountDao accountDao;

    /**
     * 测试保存
     */
    @Test
    public void testSave() {
        String salt = IdUtil.fastSimpleUUID();
        Account testSave3 = Account.builder()
                .name("testSave3")
                .password(SecureUtil.md5("123456" + salt))
                .salt(salt).email("testSave3@xkcoding.com")
                .phoneNumber("17300000003")
                .status(1)
                .lastLoginTime(LocalDateTime.now()).build();
        accountDao.save(testSave3);

        Assert.assertNotNull(testSave3.getId());
        Optional<Account> byId = accountDao.findById(testSave3.getId());
        Assert.assertTrue(byId.isPresent());
        log.debug("【byId】= {}", byId.get());
    }

    /**
     * 测试删除
     */
    @Test
    public void testDelete() {
        long count = accountDao.count();
        accountDao.deleteById(1L);
        long left = accountDao.count();
        Assert.assertEquals(count - 1, left);
    }

    /**
     * 测试修改
     */
    @Test
    public void testUpdate() {
        accountDao.findById(1L).ifPresent(Account -> {
            Account.setName("JPA修改名字");
            accountDao.save(Account);
        });
        Assert.assertEquals("JPA修改名字", accountDao.findById(1L).get().getName());
    }

    /**
     * 测试查询单个
     */
    @Test
    public void testQueryOne() {
        Optional<Account> byId = accountDao.findById(1L);
        Assert.assertTrue(byId.isPresent());
        log.debug("【byId】= {}", byId.get());
    }

    /**
     * 测试查询所有
     */
    @Test
    public void testQueryAll() {
        List<Account> Accounts = accountDao.findAll();
        Assert.assertNotEquals(0, Accounts.size());
        log.debug("【Accounts】= {}", Accounts);
    }

    /**
     * 测试分页排序查询
     */
    @Test
    public void testQueryPage() {
        // 初始化数据
        initData();
        // JPA分页的时候起始页是页码减1
        Integer currentPage = 0;
        Integer pageSize = 5;
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        PageRequest pageRequest = PageRequest.of(currentPage, pageSize, sort);
        Page<Account> AccountPage = accountDao.findAll(pageRequest);

        Assert.assertEquals(5, AccountPage.getSize());
        Assert.assertEquals(accountDao.count(), AccountPage.getTotalElements());
        log.debug("【id】= {}", AccountPage.getContent().stream().map(Account::getId).collect(Collectors.toList()));
    }

    /**
     * 初始化10条数据
     */
    private void initData() {
        List<Account> AccountList = Lists.newArrayList();
        for (int i = 0; i < 10; i++) {
            String salt = IdUtil.fastSimpleUUID();
            int index = 3 + i;
            Account account = Account.builder().name("testSave" + index).password(SecureUtil.md5("123456" + salt)).salt(salt).email("testSave" + index + "@xkcoding.com").phoneNumber("1730000000" + index).status(1).lastLoginTime(LocalDateTime.now()).build();
            AccountList.add(account);
        }
        accountDao.saveAll(AccountList);
    }

}