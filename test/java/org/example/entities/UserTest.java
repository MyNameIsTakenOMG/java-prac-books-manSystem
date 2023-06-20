package org.example.entities;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    static User user;

    @BeforeAll
    static void setUp(){
        user = new User(0,"John");
    }

    @Test
    void borrowBook() {
        //Arrange
        int bookId = 1;
        // Act
        user.borrowBook(bookId);
        // Assert
        assertEquals(bookId,user.getBorrowedBooks().get(0));
    }

    @Test
    void returnBook() {
        // Arrange
        int bookId = 1;
        // Act
        user.returnBook(bookId);
        // Assert
        assertEquals(0, user.getBorrowedBooks().size());
    }
}