package com.example.producingwebservice;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

import io.spring.guides.gs_producing_web_service.Book;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class BookRepository {
    private static final Map<String, Book> books = new HashMap<>();

    @PostConstruct      // ketika postcontruct dipanggil maka method initdata akan dijalankan
    public void initData() {
        Book kancil = new Book();
        kancil.setTitle("Kancil pintar");
        kancil.setPublisher("Adil");
        kancil.setYear(2010);
        kancil.setPrice(40000);

        books.put(kancil.getTitle(), kancil);


        Book cinderella = new Book();
        cinderella.setTitle("cinderella pun tiba, dengan kereta kencana");
        cinderella.setPublisher("Kia");
        cinderella.setYear(2007);
        cinderella.setPrice(10000);

        books.put(cinderella.getTitle(), cinderella);


        Book pauline = new Book();
        pauline.setTitle("Kisah Paulina");
        pauline.setPublisher("Paulina");
        pauline.setYear(2016);
        pauline.setPrice(90000);

        books.put(pauline.getTitle(), pauline);


    }

    public Book findBook(String name) {
        Assert.notNull(name, "The Book's name must not be null");
        return books.get(name);
    }
}
