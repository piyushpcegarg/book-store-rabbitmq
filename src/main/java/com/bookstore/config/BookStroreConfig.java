package com.bookstore.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BookStroreConfig {

    @Bean
    public Queue bookQueue() {
        return new Queue("book");
    }
}
