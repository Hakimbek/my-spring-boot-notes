package com.example.crudexample.io.spring.boot.controller;

import com.example.crudexample.io.spring.boot.model.Book;
import com.example.crudexample.io.spring.boot.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookService bookService;

    // creating a get mapping that retrieves all the books detail from the database
    @GetMapping("/book")
    private List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    // creating a get mapping that retrieves the detail of a specific book
    @GetMapping("/book/{id}")
    private Book getBook(@PathVariable("id") int id) {
        return bookService.getBookById(id);
    }

    // creating a delete mapping that deletes a specified book
    @DeleteMapping("/book/{id}")
    private void deleteBook(@PathVariable("id") int id) {
        bookService.delete(id);
    }

    // creating post mapping that post the book detail in the database
    @PostMapping("/book")
    private int saveBook(@RequestBody Book book) {
        bookService.save(book);
        return book.getId();
    }

    //creating put mapping that updates the book detail
    @PutMapping("/book/{id}")
    private Book update(@RequestBody Book book, @PathVariable int id) {
        bookService.update(book, id);
        return book;
    }

}
