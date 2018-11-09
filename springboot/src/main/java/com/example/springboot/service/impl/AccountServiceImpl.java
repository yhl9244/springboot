package com.example.springboot.service.impl;

import com.example.springboot.dao.IAccountDao;
import com.example.springboot.entity.Account;
import com.example.springboot.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by suneee on 2018/6/8.
 */
@Service
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private IAccountDao accountDao;

    @Override
    public int add(Account account){
        return accountDao.add(account);
    }

    @Override
    public int update(Account account) {
        return accountDao.update(account);
    }

    @Override
    public int delete(int id) {
        return accountDao.delete(id);
    }

    @Override
    public Account findById(int id) {
        return accountDao.findById(id);
    }

    @Override
    public List<Account> findList() {
        return accountDao.findList();

    }
}
