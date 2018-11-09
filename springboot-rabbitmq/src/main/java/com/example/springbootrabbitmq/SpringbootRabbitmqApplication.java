package com.example.springbootrabbitmq;

import com.example.springbootrabbitmq.message.Receive;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootRabbitmqApplication {

	final static String queueName = "spring-boot";

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRabbitmqApplication.class, args);
	}

	@Bean
	Queue queue() {
		return new Queue(queueName, false);
	}

	@Bean
	TopicExchange topicExchange() {
		return new TopicExchange("spring-boot-exchange");
	}

	@Bean
	Binding binding(Queue queue, TopicExchange topicExchange) {
		return BindingBuilder.bind(queue).to(topicExchange).with(queueName);
	}

	@Bean
	SimpleMessageListenerContainer container(ConnectionFactory factory, MessageListenerAdapter adapter){
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
		container.setConnectionFactory(factory);
		container.setQueueNames(queueName);
		container.setMessageListener(adapter);
		return container;
	}

	@Bean
	MessageListenerAdapter adapter(Receive receive) {
		return new MessageListenerAdapter(receive, "receiveMessage");
	}
}
