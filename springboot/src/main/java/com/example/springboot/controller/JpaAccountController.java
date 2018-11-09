package com.example.springboot.controller;

import com.example.springboot.dao.JpaAccountDao;
import com.example.springboot.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;

/**
 * Created by suneee on 2018/6/8.
 * 这里省略了service层，实际开发加上
 */
@RestController
@RequestMapping("/jpaaccount")
public class JpaAccountController {

    @Autowired
    private JpaAccountDao jpaAccountDao;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Account> getAccounts() {
        return jpaAccountDao.findAll();
    }

    /*@RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Account getAccountById(@PathVariable("id") int id) {
        return jpaAccountDao.findOne(id);
    } */

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String updateAccount(@PathVariable("id") int id, @RequestParam(value = "name", required = true) String name,
                                @RequestParam(value = "money", required = true) double money) {
        Account account = new Account();
        account.setMoney(money);
        account.setName(name);
        account.setId(id);
        Account account1 = jpaAccountDao.saveAndFlush(account);

        return account1.toString();

    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String postAccount(@RequestParam(value = "name") String name,
                              @RequestParam(value = "money") double money) {
        Account account = new Account();
        account.setMoney(money);
        account.setName(name);
        Account account1 = jpaAccountDao.save(account);
        return account1.toString();

    }

}