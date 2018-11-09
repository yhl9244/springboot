package com.example.springbootcache.dao;

import com.example.springbootcache.entity.Book;

/**
 * Created by suneee on 2018/6/14.
 */
public interface BookDao {

    Book getByIsBn(String isbn);
}
