package com.eg.swa.rabbitmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude = RabbitAutoConfiguration.class)
public class RabbitMqPointToPointApplication {

	public static void main(String[] args) {
		SpringApplication.run(RabbitMqPointToPointApplication.class, args);
	}

}