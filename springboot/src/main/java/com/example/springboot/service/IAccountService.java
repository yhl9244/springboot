package com.example.springboot.service;

import com.example.springboot.entity.Account;

import java.util.List;

/**
 * Created by suneee on 2018/6/8.
 */
public interface IAccountService {

    int add(Account account);

    int update(Account account);

    int delete(int id);

    Account findById(int id);

    List<Account> findList();
}
