package com.library.service;

import com.library.model.Book;
import com.library.model.Borrowed;
import com.library.repository.BookRepository;
import com.library.repository.BorrowedRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class LibraryServices {

    private final BookRepository bookRepository;
    private final BorrowedRepository borrowedRepository;

    public LibraryServices(BookRepository bookRepository, BorrowedRepository borrowedRepository) {
        this.bookRepository=bookRepository;
        this.borrowedRepository=borrowedRepository;
    }

    public boolean borrowBook(String bookName, String userName, Integer userId) {
        boolean status=false;
        try {
            if(getAllBooks() != null) {
                Book book = bookRepository.findByBookNameAndAvailability(bookName,true);
                if(book != null) {
                    List<Borrowed> borrowedBooks = borrowedRepository.findAllByUserId(userId);
                    if(borrowedBooks != null ) {
                        if (borrowedBooks.size() > 2) status= false;
                        else {
                            borrowedBooks.forEach(borrowedBook -> {
                                if(book.getId() != borrowedBook.getBookId()) {
                                    updateBorrowedEntity(userId,book.getId());
                                    updateBookEntity(book,false);
                                }
                            });
                            status=true;
                        }
                    }
                    else {
                        updateBorrowedEntity(userId,book.getId());
                        updateBookEntity(book,false);
                        status=true;
                    }
                }
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
            status=false;
        }

        return status;
    }

    public boolean returnBook(List<Integer> bookIds, List<Integer> userIds) {
        boolean status =false;
        try {
            for(Integer bookId:bookIds) {
                Optional<Book> book = bookRepository.findById(bookId);
                updateBookEntity(book.get(),true);
            }

            for(int i=0;i<=bookIds.size();i++) {
                Borrowed borrowed = borrowedRepository.findByuserIdAndBookId(userIds.get(i),bookIds.get(i));
                borrowedRepository.delete(borrowed);
            }

            status = true;
        }
        catch (Exception ex) {
            ex.printStackTrace();
            status=false;
        }
        return status;
    }

    public void updateBorrowedEntity(Integer userId, Integer bookId) {
        Borrowed borrowed = new Borrowed();
        borrowed.setUserId(userId);
        borrowed.setBookId(bookId);
        borrowedRepository.save(borrowed);
    }

    public void updateBookEntity(Book book, Boolean availability) {
        book.setAvailability(availability);
        bookRepository.save(book);
    }


    public List<Book> getAllBooks() {
        return (bookRepository.findAll()!= null &&  !bookRepository.findAll().isEmpty())?bookRepository.findAll():null;
    }

}
