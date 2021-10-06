package com.bookstore.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bookstore.model.Book;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private static final Map<Integer, String> books = new HashMap<>();

    private final RabbitTemplate template;
    private final Queue queue;

    public BookService(RabbitTemplate template, Queue queue) {
        this.template = template;
        this.queue = queue;
        books.put(1, "Book 1");
        books.put(2, "Book 2");
    }

    public List<Book> getBooks() {

        List<Book> bookList = new ArrayList<>(2);

        for (Map.Entry<Integer, String> bookEntry : books.entrySet()) {

            Book book = new Book(bookEntry.getKey(), bookEntry.getValue());
            bookList.add(book);
        }
        return bookList;
    }

    public void likeBook(Integer id) {

        System.out.println(books.get(id) + " has been liked");

        this.template.convertAndSend(queue.getName(), books.get(id));
    }
}
