package com.library.repository;

import com.library.model.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Integer> {

    List<Book> findAll();

    Book findByBookNameAndAvailability(String bookName,Boolean availability);
}
