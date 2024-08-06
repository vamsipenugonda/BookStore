package com.springboot.booksstore.controller;

import com.springboot.booksstore.entity.Book;
import com.springboot.booksstore.services.BookStoreService;
import com.springboot.booksstore.services.BookStoreServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("bookingservice")
public class BookStoreController {
    @Autowired
    BookStoreServiceImpl bookStoreService;

    @GetMapping("books")
    public ResponseEntity<List<Book>> getBooks(){
        List<Book> books= bookStoreService.getBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }
    @GetMapping("books/{id}")
    public ResponseEntity<Book> getBook(@PathVariable("id") int id){
        Book book = bookStoreService.getBook(id);
        return new ResponseEntity<>(book,HttpStatus.OK);
    }
    @PostMapping("books")
    public ResponseEntity<Book> postBook(@RequestBody Book book){
        Book book1=bookStoreService.createBook(book);
        return new ResponseEntity<>(book1,HttpStatus.OK);
    }
    @PutMapping("books/{id}")
    public ResponseEntity<Book> putBook(@PathVariable("id")int id,@RequestBody Book book){
        Book book1 = bookStoreService.updateBook(id,book);
        return new ResponseEntity<>(book1,HttpStatus.OK);
    }
    @DeleteMapping("books/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable("id")int id){
        boolean x=bookStoreService.deleteBook(id);
        if(x==true){
            String response="Book sucessfully  deleted";
            return new ResponseEntity<>(response,HttpStatus.OK);
        }
        String ans="Not able Delete Book";
        return new ResponseEntity<>(ans,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
