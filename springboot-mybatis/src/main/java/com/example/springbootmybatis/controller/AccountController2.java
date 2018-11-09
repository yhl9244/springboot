package com.example.springbootmybatis.controller;

import com.example.springbootmybatis.dao.AccountMapper;
import com.example.springbootmybatis.service.AccountService;
import com.example.springbootmybatis.service.AccountService2;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by suneee on 2018/6/11.
 */
@RestController
@RequestMapping("/account2")
@MapperScan("com.example.springbootmybatis.dao")
public class AccountController2 {

    @Autowired
    AccountService2 accountService2;

    @RequestMapping(value = "/transfer", method = RequestMethod.GET)
    public void transfer() {
        accountService2.transfer();
    }
}
