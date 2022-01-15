package com.example.crudexample.io.spring.boot.service;

import com.example.crudexample.io.spring.boot.model.Book;
import com.example.crudexample.io.spring.boot.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    // getting all books record by using the method findAll() of CrudRepository
    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<Book>();
        bookRepository.findAll().forEach(books::add);
        return books;
    }

    // getting a specific record by using the method findById() of CrudRepository
    public Book getBookById(int id) {
        return bookRepository.findById(id).get();
    }

    // saving a specific record by using the method save() of CrudRepository
    public void save(Book book) {
        bookRepository.save(book);
    }

    // deleting a specific record by using the method deleteById() of CrudRepository
    public void delete(int id) {
        if (bookRepository.findById(id).isPresent()) {
            bookRepository.deleteById(id);
        }
    }

    // updating a record
    public void update(Book book, int id) {
        bookRepository.save(book);
    }

}
