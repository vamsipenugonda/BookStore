package com.springboot.booksstore.repository;

import com.springboot.booksstore.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface BookRepositoryImpl extends JpaRepository<Book,Integer> {



}
