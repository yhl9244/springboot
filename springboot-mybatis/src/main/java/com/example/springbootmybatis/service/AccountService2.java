package com.example.springbootmybatis.service;

import com.example.springbootmybatis.dao.AccountMapper;
import com.example.springbootmybatis.dao.AccountMapper2;
import com.example.springbootmybatis.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by suneee on 2018/6/11.
 */
@Service
public class AccountService2 {

    @Autowired
    AccountMapper2 accountMapper2;

    @Transactional
    public void transfer() throws RuntimeException{
        accountMapper2.update(90,1);//用户1减10块 用户2加10块
        accountMapper2.update(110,2);
    }

}
