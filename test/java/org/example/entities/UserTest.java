package org.example.entities;

import org.junit.jupiter.api.*;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserTest {

    static User user;

    @BeforeAll
    static void setUp(){
        user = new User(0,"John");
    }

    @Test
    @Order(1)
    void borrowBook() {
        //Arrange
        int bookId = 1;
        // Act
        user.borrowBook(bookId);
        // Assert
        assertEquals(bookId,user.getBorrowedBooks().get(0));
    }

    @Test
    @Order(2)
    void returnBook() {
        // Arrange
        int bookId = 1;
        // Act
        user.returnBook(bookId);
        // Assert
        assertEquals(0, user.getBorrowedBooks().size());
    }
}