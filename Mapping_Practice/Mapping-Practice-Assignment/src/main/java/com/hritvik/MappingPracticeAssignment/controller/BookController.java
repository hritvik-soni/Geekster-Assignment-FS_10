package com.hritvik.MappingPracticeAssignment.controller;

import com.hritvik.MappingPracticeAssignment.model.Book;
import com.hritvik.MappingPracticeAssignment.model.Course;
import com.hritvik.MappingPracticeAssignment.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    @Autowired
    BookService bookService;

    @PostMapping("book")
    public void addWorker(@RequestBody Book book)
    {
        bookService.addBook(book);
    }
}
