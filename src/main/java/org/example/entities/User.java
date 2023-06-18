package org.example.entities;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int id;
    private String name;

    private List<Integer> borrowedBooks;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    public void borrowBook(int bookId){
        borrowedBooks.add(bookId);
        System.out.println("borrowed the book with id "+bookId);
    }

    public List<Integer> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void returnBook(int bookId){
        borrowedBooks.removeIf(b->b==bookId);
        System.out.println("returned the book with id "+bookId);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
