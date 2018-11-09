package com.example.springbootbeatlsql.controller;

import com.example.springbootbeatlsql.dao.AccountDao;
import com.example.springbootbeatlsql.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by suneee on 2018/6/9.
 */
@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountDao accountDao;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public  List<Account> getAccounts(){
        return accountDao.all();
    }


}
