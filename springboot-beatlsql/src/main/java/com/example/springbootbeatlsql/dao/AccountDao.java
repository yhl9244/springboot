package com.example.springbootbeatlsql.dao;

import com.example.springbootbeatlsql.entity.Account;
import org.beetl.sql.core.annotatoin.SqlStatement;
import org.beetl.sql.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * Created by suneee on 2018/6/9.
 */
@Repository
public interface AccountDao extends BaseMapper<Account> {

    @SqlStatement(params = "name")
    Account selectAccountByName(String name);
}
