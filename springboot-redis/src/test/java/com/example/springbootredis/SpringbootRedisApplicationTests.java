package com.example.springbootredis;

import com.example.springbootredis.dao.RedisDao;
import net.bytebuddy.asm.Advice;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootRedisApplicationTests {

	public static Logger logger = LoggerFactory.getLogger(SpringbootRedisApplicationTests.class);

	@Test
	public void contextLoads() {
	}

	@Autowired
	RedisDao redisDao;

	@Test
	public void testRedis() {
		redisDao.setKey("name", "yhl");
		redisDao.setKey("age", "12");
		logger.info(redisDao.getValue("name"));
		logger.info(redisDao.getValue("age"));
	}

}
