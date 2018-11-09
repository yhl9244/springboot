package com.example.springbootmybatis.dao;

import com.example.springbootmybatis.entity.Account;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by suneee on 2018/6/11.
 */
@Mapper
public interface AccountMapper2 {

    int update(@Param("money") double money, @Param("id") int id);

}
