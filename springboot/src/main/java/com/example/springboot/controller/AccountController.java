package com.example.springboot.controller;

import com.example.springboot.entity.Account;
import com.example.springboot.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by suneee on 2018/6/8.
 */
@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private IAccountService accountService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<Account> getAccounts(){
        return accountService.findList();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public  Account getAccountById(@PathVariable("id") int id){
        return accountService.findById(id);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public  String updateAccount(@PathVariable("id")int id , @RequestParam(value = "name",required = true)String name,
                                 @RequestParam(value = "money" ,required = true)double money){
        Account account=new Account();
        account.setMoney(money);
        account.setName(name);
        account.setId(id);
        int t=accountService.update(account);
        if(t==1){
            return account.toString();
        }else {
            return "fail";
        }
    }

    @RequestMapping(value = "",method = RequestMethod.POST)
    public  String postAccount( @RequestParam(value = "name")String name,
                                @RequestParam(value = "money" )double money){
        Account account=new Account();
        account.setMoney(money);
        account.setName(name);
        int t= accountService.add(account);
        if(t==1){
            return account.toString();
        }else {
            return "fail";
        }

    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public int delete(@PathVariable("id") int id){
        return accountService.delete(id);
    }

}