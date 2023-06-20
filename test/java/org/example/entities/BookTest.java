package org.example.entities;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    static Book book;

    @BeforeAll
    static void setUp(){
        int id = 0;
        String name = "great expectation";
        book = new Book(id,name);
    }

    @Test
    void getRentedBy() {
        assertEquals(-1,book.getRentedBy());
    }

    @Test
    void setRentedBy() {
        int id = 1;
        book.setRentedBy(id);
        assertEquals(id, book.getRentedBy());
    }

    @Test
    void unrent() {
        book.unrent();
        assertEquals(-1, book.getRentedBy());
    }
}