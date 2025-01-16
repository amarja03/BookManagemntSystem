package com.tka.BookManagement.Controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tka.BookManagement.Entity.Book;
import com.tka.BookManagement.Services.BookService;
@RestController
@RequestMapping("/book")

public class BookController {
	BookService bookService=new BookService();
	
@PostMapping("/addbook")

public void insertBook(@RequestBody Book book) {
	bookService.insertBook(book);
}

@GetMapping("getallbooks")
public List<Book> getAllBooks() {
    return bookService.getallbooks();
}
@DeleteMapping("deletebooks")
public void deletebook(@RequestParam int id) {
	bookService.deletebooks(id);
}
@GetMapping("getbookbyid/{id}")
    public Book fetchbookByID(@PathVariable Integer id) throws SQLException {
        return bookService.fetchbookbyID(id);
    }
}
