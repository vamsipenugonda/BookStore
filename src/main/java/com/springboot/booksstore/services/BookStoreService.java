package com.springboot.booksstore.services;

import com.springboot.booksstore.entity.Book;
import org.springframework.stereotype.Service;

import java.util.List;
public interface BookStoreService {
    List<Book> getBooks();
    Book createBook(Book book);
    Book updateBook(int bookId, Book book);
    Book getBook(int bookId);
    boolean deleteBook(int bookId);
}
