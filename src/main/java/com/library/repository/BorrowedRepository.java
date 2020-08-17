package com.library.repository;

import com.library.model.Book;
import com.library.model.Borrowed;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BorrowedRepository extends CrudRepository<Borrowed, Integer> {
    List<Borrowed> findAllByUserId(Integer userId);
    Borrowed findByuserIdAndBookId(Integer userId, Integer bookId);
}
