package com.bookstore.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    private static final Map<String, Integer> bookStore = new HashMap<>();

    public AdminService() {

        bookStore.put("Book 1", 0);
        bookStore.put("Book 2", 0);
    }

    public Map<String, Integer> showBooks() {
        return bookStore;
    }

    @RabbitListener(queues = "book")
    public void processMessage(String bookName) {

        System.out.println(bookName + " received");
        Integer likes = bookStore.get(bookName);
        bookStore.put(bookName, ++likes);
    }
  
}
