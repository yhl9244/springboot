package com.example.springbootcache.dao.impl;

import com.example.springbootcache.dao.BookDao;
import com.example.springbootcache.entity.Book;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * Created by suneee on 2018/6/14.
 */
@Component
public class BookDaoImpl implements BookDao {

    @Override
    @Cacheable(value = "book")
    public Book getByIsBn(String isbn) {
        simulateSlowService();
        return new Book(isbn, "Some book");
    }

    // Don't do this at home
    private void simulateSlowService() {
        try {
            long time = 3000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
}
