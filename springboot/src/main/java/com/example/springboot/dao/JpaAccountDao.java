package com.example.springboot.dao;

import com.example.springboot.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by suneee on 2018/6/8.
 */
public interface JpaAccountDao  extends JpaRepository<Account,Integer> {
}
