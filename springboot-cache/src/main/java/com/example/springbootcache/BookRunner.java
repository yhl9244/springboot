package com.example.springbootcache;

import com.example.springbootcache.dao.BookDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by suneee on 2018/6/14.
 */
@Component
public class BookRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(BookRunner.class);

    private final BookDao bookDao;

    public BookRunner(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info(".... Fetching books");
        logger.info("isbn-1234 -->" + bookDao.getByIsBn("isbn-1234"));
        logger.info("isbn-4567 -->" + bookDao.getByIsBn("isbn-4567"));
        logger.info("isbn-1234 -->" + bookDao.getByIsBn("isbn-1234"));
        logger.info("isbn-4567 -->" + bookDao.getByIsBn("isbn-4567"));
        logger.info("isbn-1234 -->" + bookDao.getByIsBn("isbn-1234"));
        logger.info("isbn-1234 -->" + bookDao.getByIsBn("isbn-1234"));
    }
}
