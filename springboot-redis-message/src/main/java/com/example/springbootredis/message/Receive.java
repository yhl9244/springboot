package com.example.springbootredis.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.CountDownLatch;

/**
 * Created by suneee on 2018/6/14.
 */
public class Receive {

    public static  final Logger LOGGER = LoggerFactory.getLogger(Receive.class);

    private CountDownLatch countDownLatch;

    @Autowired
    public Receive(CountDownLatch countDownLatch){
        this.countDownLatch = countDownLatch;
    }

    public void receiveMessage(String message) {
        LOGGER.info("Receive <" + message + ">");
        countDownLatch.countDown();
    }
}
