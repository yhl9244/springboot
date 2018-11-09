package com.example.springbootredis;

import com.example.springbootredis.message.Receive;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

import java.util.concurrent.CountDownLatch;

@SpringBootApplication
public class SpringbootRedisApplication {

	public static final Logger LOGGER = LoggerFactory.getLogger(SpringbootRedisApplication.class);

	@Bean
	RedisMessageListenerContainer container(RedisConnectionFactory factory, MessageListenerAdapter adapter){
		RedisMessageListenerContainer container = new RedisMessageListenerContainer();
		container.setConnectionFactory(factory);
		container.addMessageListener(adapter, new PatternTopic("chat"));
		return container;
	}

	@Bean
	MessageListenerAdapter adapter(Receive receive) {
		return new MessageListenerAdapter(receive, "receiveMessage");
	}

	@Bean
	StringRedisTemplate template(RedisConnectionFactory factory){
		return new StringRedisTemplate(factory);
	}

	public static void main(String[] args) throws Exception {
		ApplicationContext context = SpringApplication.run(SpringbootRedisApplication.class, args);

		StringRedisTemplate template = context.getBean(StringRedisTemplate.class);
		CountDownLatch countDownLatch =context.getBean(CountDownLatch.class);

		LOGGER.info("Sending Message .....");
		template.convertAndSend("chat", "Hello from Redis!");

		countDownLatch.await();

		System.exit(0);

	}

	@Bean
	Receive receive(CountDownLatch countDownLatch){
		return new Receive(countDownLatch);
	}

	@Bean
	CountDownLatch countDownLatch(){
		return new CountDownLatch(1);
	}

}
