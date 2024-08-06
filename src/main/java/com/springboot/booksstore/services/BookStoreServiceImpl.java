package com.springboot.booksstore.services;

import com.springboot.booksstore.entity.Book;
import com.springboot.booksstore.repository.BookRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookStoreServiceImpl implements BookStoreService{
    @Autowired
    BookRepositoryImpl repository;
    @Override
    public List<Book> getBooks() {
        List<Book> books = new ArrayList<>();
        books=repository.findAll();
        return books;
    }

    @Override
    public Book createBook(Book book) {
        Book book1=repository.save(book);
        return book1;
    }

    @Override
    public Book updateBook(int bookId, Book book) {
        Optional<Book> optionalBook=repository.findById(bookId);
        if(!optionalBook.isEmpty()){
            Book book1=optionalBook.get();
            book1.setName(book.getName());
            book1.setAuthor(book.getAuthor());
            book1.setPrice(book.getPrice());
            book1.setPages(book.getPages());
            book1.setPublication(book.getPublication());
            Book book2=repository.save(book1);
            return book2;
        }
        return null;
    }

    @Override
    public Book getBook(int bookId) {
        Optional<Book> optionalBook =repository.findById(bookId);
        if(optionalBook.isEmpty()){
            return null;
        }
        return optionalBook.get();
    }

    @Override
    public boolean deleteBook(int bookId) {
        return false;
    }
}
