package org.example.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ControlPanel {
    private ManSystem bookSys;
    private String option;
    private Scanner userInput;

    public ControlPanel(ManSystem bookSys, Scanner userInput) {
        this.bookSys = bookSys;
        this.option = "";
        this.userInput = userInput;
    }

    public void start(){
        while(!option.equals("q")){
//            System.out.println("call menu... and the option: "+option);
            Menu.getMenu();
            option = userInput.nextLine();
            switch (option) {
                case "u" -> {
                    addUser();
                }
                case "a" -> {
                    addBook();
                }
                case "i" -> {
                    getBookById();
                }
                case "n" -> {
                    getBooksByName();
                }
                case "b", "r" -> {
                    borrowOrReturn();
                }
                default -> {
                }
            }
        }
        System.out.println("management system is closed");
    }
    public void getBooksByName(){
        System.out.println("please type book name");
        String bookname = userInput.nextLine();
        var searchingBooks = bookSys.getBooksByName(bookname);
        System.out.println("searching book result: " + searchingBooks);
    }
    public void getBookById(){
        System.out.println("please type book id");
//                    bookId = userInput.nextInt();
        int bookId = Integer.parseInt(userInput.nextLine());
        var books = bookSys.getBooks();
        Book theBook = books.get(bookId);
        System.out.println("the searched book: " + theBook);
    }

    public void addBook(){
        System.out.println("please type bookname: ");
        String bookname = userInput.nextLine();
        bookSys.addBook(bookname);
        Book theBook = bookSys.getBookById(bookSys.getCurrentBookId() - 1);
        System.out.println("the new book: " + theBook);
    }
    public void addUser(){
        System.out.println("please type username: ");
        String username = userInput.nextLine();
        var newUser = bookSys.createUser(username);
        bookSys.addUser(newUser);
        // print out the user just created
        User theUser = bookSys.getUser(bookSys.getCurrentUserId() - 1);
        System.out.println("the new user: " + theUser);
    }

    public void borrowOrReturn(){
        String operation = option.equals("b")? "borrow":"return";
        // borrow or return books
        System.out.println("please type user id");
//                    userId = userInput.nextInt();
        int userId = Integer.parseInt(userInput.nextLine());
        User theUser = bookSys.getUsers().get(userId);
        // take book id(s)
        List<Integer> bookIds = generateList();
        if(operation.equals("borrow"))
            bookSys.borrowBooks(
                    userId,
                    bookIds.get(0),
                    bookIds.subList(1, bookIds.size()).toArray(new Integer[0])
            );
        else
            bookSys.returnBooks(
                    userId,
                    bookIds.get(0),
                    bookIds.subList(1, bookIds.size()).toArray(new Integer[0])
            );
        System.out.println("borrowed books: " + theUser.getBorrowedBooks());
        System.out.println("first book borrowed by: " + bookSys.getBooks().get(bookIds.get(0)).getRentedBy());
    }

    public List<Integer> generateList(){
        String continuing = "y";
        List<Integer> theList = new ArrayList<>();
        int num;
        while (continuing.equals("y")) {
            System.out.println("please enter a number");
//                        bookId = userInput.nextInt();
            num = Integer.parseInt(userInput.nextLine());
            theList.add(num);
            System.out.println("continue? (y/n)");
            continuing = userInput.nextLine();
        }
        return theList;
    }
}
