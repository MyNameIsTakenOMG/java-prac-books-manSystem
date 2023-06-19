package org.example;

import org.example.entities.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        ControlPanel controlPanel = new ControlPanel(new ManSystem(),new Scanner(System.in));

        controlPanel.start();

//        var bookSys = new ManSystem();
//
//        String option = "";
//        Scanner userInput = new Scanner(System.in);
//
//
//        while(!option.equals("q")){
//            System.out.println("call menu... and the option: "+option);
//            Menu.getMenu();
//            option = userInput.nextLine();
//            User theUser;
//            Book theBook;
//            String bookname;
//            int bookId;
//            switch (option) {
//                case "u" -> {
//                    // add a new user
//                    System.out.println("please type username: ");
//                    String username = userInput.nextLine();
//                    bookSys.addUser(username);
//                    // print out the user just created
//                    theUser = bookSys.getUser(bookSys.getCurrentUserId() - 1);
//                    System.out.println("the new user: " + theUser);
//                }
//                case "a" -> {
//                    // add a new book
//                    System.out.println("please type bookname: ");
//                    bookname = userInput.nextLine();
//                    bookSys.addBook(bookname);
//                    theBook = bookSys.getBookById(bookSys.getCurrentBookId() - 1);
//                    System.out.println("the new book: " + theBook);
//                }
//                case "i" -> {
//                    // get a book by id
//                    System.out.println("please type book id");
////                    bookId = userInput.nextInt();
//                    bookId = Integer.parseInt(userInput.nextLine());
//                    theBook = bookSys.books.get(bookId);
//                    System.out.println("the searched book: " + theBook);
//                }
//                case "n" -> {
//                    // get books by name
//                    System.out.println("please type book name");
//                    bookname = userInput.nextLine();
//                    var searchingBooks = bookSys.getBooksByName(bookname);
//                    System.out.println("searching book result: " + searchingBooks);
//                }
//                case "b", "r" -> {
//                    // borrow books
//                    borrowOrReturn(option,bookSys,userInput);
//                }
//                // return books
//                default -> {
//                }
//            }
//        }
//        System.out.println("management system is closed");

    }
//    public static void borrowOrReturn(String option, ManSystem bookSys, Scanner userInput){
//        String operation = option.equals("b")? "borrow":"return";
//        // borrow or return books
//        System.out.println("please type user id");
////                    userId = userInput.nextInt();
//        int userId = Integer.parseInt(userInput.nextLine());
//        User theUser = bookSys.users.get(userId);
//        // take book id(s)
//        List<Integer> bookIds = generateList(userInput);
//        if(operation.equals("borrow"))
//            bookSys.borrowBooks(
//                    userId,
//                    bookIds.get(0),
//                    bookIds.subList(1, bookIds.size()).toArray(new Integer[0])
//            );
//        else
//            bookSys.returnBooks(
//                    userId,
//                    bookIds.get(0),
//                    bookIds.subList(1, bookIds.size()).toArray(new Integer[0])
//            );
//        System.out.println("borrowed books: " + theUser.getBorrowedBooks());
//        System.out.println("first book borrowed by: " + bookSys.books.get(bookIds.get(0)).getRentedBy());
//    }

//    public static List<Integer> generateList(Scanner input){
//        String continuing = "y";
//        List<Integer> theList = new ArrayList<>();
//        int num;
//        while (continuing.equals("y")) {
//            System.out.println("please enter a number");
////                        bookId = userInput.nextInt();
//            num = Integer.parseInt(input.nextLine());
//            theList.add(num);
//            System.out.println("continue to? (y/n)");
//            continuing = input.nextLine();
//        }
//        return theList;
//    }
}