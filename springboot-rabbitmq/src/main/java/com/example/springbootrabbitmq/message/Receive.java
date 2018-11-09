package com.example.springbootrabbitmq.message;

import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

/**
 * Created by suneee on 2018/6/14.
 */
@Component
public class Receive {

    private CountDownLatch latch = new CountDownLatch(1);

      public void receiveMessage(String message) {
        System.out.println("Received <" + message + ">");
        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }

}
