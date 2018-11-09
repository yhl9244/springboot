package com.example.springbootrabbitmq;

import com.example.springbootrabbitmq.message.Receive;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * Created by suneee on 2018/6/14.
 */
@Component
public class Runner implements CommandLineRunner {

    private final RabbitTemplate rabbitTemplate;
    private final Receive receive;
    private final ConfigurableApplicationContext context;

    public Runner(RabbitTemplate rabbitTemplate, Receive receive, ConfigurableApplicationContext context){
        this.rabbitTemplate = rabbitTemplate;
        this.receive = receive;
        this.context = context;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Sending message...");
        rabbitTemplate.convertAndSend(SpringbootRabbitmqApplication.queueName, "Hello from RabbitMQ!");
        receive.getLatch().await(10000, TimeUnit.MILLISECONDS);
        context.close();
    }
}
