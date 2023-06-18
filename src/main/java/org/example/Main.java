package org.example;

import org.example.entities.ManSystem;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        var bookSys = new ManSystem();

        // add a new user
        bookSys.addUser("John");
        // print out the user just created
        var theUser = bookSys.getUser(bookSys.getCurrentUserId()-1);
        System.out.println("the new user: "+theUser);

        // add a new book
        bookSys.addBook("great expectation");
        var theBook = bookSys.getBookById(bookSys.getCurrentBookId()-1);
        System.out.println("the new book: "+theBook);
        // add another book
        bookSys.addBook("great expectation");
        var searchingBooks = bookSys.getBooksByName("great expectation");
        System.out.println("searching book result: "+searchingBooks);

        // borrow books for the user with id of 0
        bookSys.borrowBooks(0,0,1);
        System.out.println("borrowed books: "+ theUser.getBorrowedBooks());
    }
}