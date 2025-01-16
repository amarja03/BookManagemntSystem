package com.tka.BookManagement.Services;


import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.tka.BookManagement.Dao.BookDao;
import com.tka.BookManagement.Entity.Book;
@Service
public class BookService {
	BookDao bookDao=new BookDao();
	public void insertBook(Book book) {
		bookDao.insertBook(book);
	}
	public List<Book> getallbooks() {
        return bookDao.getallbooks();
    }
	public void deletebooks(int id) {
		bookDao.deletebooks(id);
	}

    public Book fetchbookbyID(int id) throws SQLException {
        return bookDao.fetchbookbyID(id);
    }
}
