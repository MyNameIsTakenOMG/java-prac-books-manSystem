package org.example.entities;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BookTest {

    static Book book;

    @BeforeAll
    static void setUp(){
        int id = 0;
        String name = "great expectation";
        book = new Book(id,name);
    }

    @Test
    @Order(1)
    void getRentedBy() {
        assertEquals(-1,book.getRentedBy());
    }

    @Test
    @Order(2)
    void setRentedBy() {
        int id = 1;
        book.setRentedBy(id);
        assertEquals(id, book.getRentedBy());
    }

    @Test
    @Order(3)
    void unrent() {
        book.unrent();
        assertEquals(-1, book.getRentedBy());
    }
}