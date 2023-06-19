package org.example;

import org.example.entities.Book;
import org.example.entities.ManSystem;
import org.example.entities.Menu;
import org.example.entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        var bookSys = new ManSystem();

        String option = "";
        Scanner userInput = new Scanner(System.in);


        while(!option.equals("q")){
            System.out.println("call menu... and the option: "+option);
            Menu.getMenu();
            option = userInput.nextLine();
            User theUser;
            Book theBook;
            String bookname;
            int userId;
            int bookId;
            List<Integer> bookIds;
            String continuing = "y";
            switch (option) {
                case "u" -> {
                    // add a new user
                    System.out.println("please type username: ");
                    String username = userInput.nextLine();
                    bookSys.addUser("John");
                    // print out the user just created
                    theUser = bookSys.getUser(bookSys.getCurrentUserId() - 1);
                    System.out.println("the new user: " + theUser);
                }
                case "a" -> {
                    // add a new book
                    System.out.println("please type bookname: ");
                    bookname = userInput.nextLine();
                    bookSys.addBook(bookname);
                    theBook = bookSys.getBookById(bookSys.getCurrentBookId() - 1);
                    System.out.println("the new book: " + theBook);
                }
                case "i" -> {
                    // get a book by id
                    System.out.println("please type book id");
//                    bookId = userInput.nextInt();
                    bookId = Integer.parseInt(userInput.nextLine());
                    theBook = bookSys.books.get(bookId);
                    System.out.println("the searched book: " + theBook);
                }
                case "n" -> {
                    // get books by name
                    System.out.println("please type book name");
                    bookname = userInput.nextLine();
                    var searchingBooks = bookSys.getBooksByName(bookname);
                    System.out.println("searching book result: " + searchingBooks);
                }
                case "b" -> {
                    // borrow books
                    System.out.println("please type user id");
//                    userId = userInput.nextInt();
                    userId = Integer.parseInt(userInput.nextLine());
                    theUser = bookSys.users.get(userId);
                    // take book id(s)
                    bookIds = new ArrayList<>();
                    while (continuing.equals("y")) {
                        System.out.println("please type book id");
//                        bookId = userInput.nextInt();
                        bookId = Integer.parseInt(userInput.nextLine());
                        bookIds.add(bookId);
                        System.out.println("continue to borrow? (y/n)");
                        continuing = userInput.nextLine();
                    }
                    bookSys.borrowBooks(
                            userId,
                            bookIds.get(0),
                            bookIds.subList(1, bookIds.size()).toArray(new Integer[0])
                    );
                    System.out.println("borrowed books: " + theUser.getBorrowedBooks());
                    System.out.println("first book borrowed by: " + bookSys.books.get(bookIds.get(0)).getRentedBy());
                }
                case "r" -> {
                    // return books
                    System.out.println("please type user id");
//                    userId = userInput.nextInt();
                    userId = Integer.parseInt(userInput.nextLine());
                    theUser = bookSys.users.get(userId);
                    // take book id(s)
                    bookIds = new ArrayList<>();
                    while (continuing.equals("y")) {
                        System.out.println("please type book id");
//                        bookId = userInput.nextInt();
                        bookId = Integer.parseInt(userInput.nextLine());
                        bookIds.add(bookId);
                        System.out.println("continue to borrow? (y/n)");
                        continuing = userInput.nextLine();
                    }
                    bookSys.returnBooks(
                            userId,
                            bookIds.get(0),
                            bookIds.subList(1, bookIds.size()).toArray(new Integer[0])
                    );
                    System.out.println("borrowed books: " + theUser.getBorrowedBooks());
                    System.out.println("first book borrowed by: " + bookSys.books.get(bookIds.get(0)).getRentedBy());
                }
                default -> {
                }
            }
        }
        System.out.println("management system is closed");

    }
}