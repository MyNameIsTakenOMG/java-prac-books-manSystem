package org.example.entities;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
class ManSystemTest {
    static ManSystem manSystem;
    static User user;
    static String username;
    static Book book1;
    static Book book2;
    static String name1;
    static String name2;

    @BeforeAll
    static void setUp(){
        manSystem = new ManSystem();
        username = "John";
        name1 = "great";
        name2 = "great";
    }

    @Test
    @Order(1)
    void createUser(){
        user = manSystem.createUser(username);
        assertInstanceOf(User.class,user);
        assertEquals(username,user.getName());
        assertEquals(0,user.getId());
    }
    @Test
    @Order(2)
    void addUser() {
        manSystem.addUser(user);
        assertEquals(1,manSystem.getUsers().size());
    }

    @Test
    @Order(3)
    void getUser() {
        var theUser = manSystem.getUser(0);
        assertEquals(0, theUser.getId());
        assertEquals(username,theUser.getName());
    }

    @Test
    @Order(4)
    void addBook() {
        manSystem.addBook(name1);
        manSystem.addBook(name2);
        assertEquals(2, manSystem.getBooks().size());
        assertEquals(name1, manSystem.getBooks().get(0).getName());
        assertEquals(name2, manSystem.getBooks().get(1).getName());
    }

    @Test
    @Order(5)
    void getBookById() {
        var book = manSystem.getBookById(0);
        assertEquals(0, book.getId());
    }

    @Test
    @Order(6)
    void getBooksByName() {
        var books = manSystem.getBooksByName(name1);
        book1 = books.get(0);
        book2 = books.get(1);
        assertEquals(2, books.size());
        assertEquals(name1,book1.getName());
        assertEquals(name1,book2.getName());
    }

    @Test
    @Order(7)
    void borrowBooks() {
        manSystem.borrowBooks(user.getId(),book1.getId(),book2.getId());
        Integer[] expected = {book1.getId(),book2.getId()};
        var borrowedBooks = user.getBorrowedBooks().toArray(new Integer[0]);
        assertArrayEquals(expected,borrowedBooks);
        assertEquals(user.getId(),book1.getRentedBy());
        assertEquals(user.getId(),book2.getRentedBy());
    }

    @Test
    @Order(8)
    void returnBooks() {
        manSystem.returnBooks(user.getId(),book1.getId(),book2.getId());
        assertEquals(0,user.getBorrowedBooks().size());
        assertEquals(-1, book1.getRentedBy());
        assertEquals(-1, book2.getRentedBy());
    }

}