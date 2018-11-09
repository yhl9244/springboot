package com.example.springboot.dao;

import com.example.springboot.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by suneee on 2018/6/8.
 */
public interface IAccountDao {

    int add(Account account);

    int update(Account account);

    int delete(int id);

    Account findById(int id);

    List<Account> findList();

}
