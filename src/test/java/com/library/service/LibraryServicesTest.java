package com.library.service;


import com.library.repository.BookRepository;
import com.library.repository.BorrowedRepository;
import org.junit.*;
import org.mockito.Mock;

import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;

import static org.assertj.core.api.Assertions.assertThat;

public class LibraryServicesTest {

    @Mock
    BookRepository bookRepository;

    @Mock
    BorrowedRepository borrowedRepository;

    private LibraryServices libraryServices;

    @Before
    public void setUp() {
        libraryServices = new LibraryServices(bookRepository,borrowedRepository);
    }

    @Test
    public void borrowBookSuccess() {
        assertThat(libraryServices.borrowBook("ava Basics and Advance level",
                "martin@abc.de",any())).isTrue();
    }

    @Test
    public void borrowBookFailed() {
        assertThat(libraryServices.borrowBook("Abc",
                "123@abc.de",any())).isFalse();
    }

    @Test
    public void returnBookSucccess() {
        assertThat(libraryServices.returnBook(any(),any())).isTrue();
    }

    @Test
    public void returnBookFailed() {
        assertThat(libraryServices.returnBook(Collections.singletonList(1234),
                Collections.singletonList(4546))).isFalse();
    }

    @Test
    public void getAllBooksNotNull() {
        assertThat(libraryServices.getAllBooks()).isNotNull();
    }
}