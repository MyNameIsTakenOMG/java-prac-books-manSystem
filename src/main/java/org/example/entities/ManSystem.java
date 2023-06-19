package org.example.entities;

import java.util.*;

public class ManSystem {
    public List<Book> books;
    private int currentBookId;
//    public List<User> users;
    public HashMap<Integer, User> users;
    private int currentUserId;

    public ManSystem() {
        this.books = new ArrayList<>();
        this.currentBookId = 0;
//        this.users = new ArrayList<>();
        this.users = new HashMap<>();
        this.currentUserId = 0;
    }

    // add a new user
    public void addUser(String username){
        int userId = currentUserId++;
        var newUser = new User(userId, username);
        users.put(userId,newUser);
        System.out.println("the new user has been added");
    }
    public User getUser(int userId){
        return users.get(userId);
    }

    public void addBook(String bookname){
        int bookId = currentBookId++;
        var newBook = new Book(bookId, bookname);
        books.add(newBook);
        System.out.println("the new book has been added");
    }
    public Book getBookById(int bookId){
        return books.get(bookId);
    }
    public List<Book> getBooksByName(String bookname){
        return books.stream()
                .filter(book->book.getName().equals(bookname))
                .toList();
    }

    // borrow books
    public void borrowBooks(int userId, int firstBookId, int ...otherBookIds){
        // validate userId and bookId(s) first before performing borrow operation
        if(!users.containsKey(userId) || !(0 <=firstBookId && firstBookId < books.size()))
            throw new IllegalArgumentException("invalid user id or book id");
        for (int id : otherBookIds) {
            System.out.println("book id: "+id);
            if (!(0 <= id && id < books.size()))
                throw new IllegalArgumentException("invalid book id");
        }
        // remove the duplicates of bookId(s)
        Set<Integer> bookIdSet = new HashSet<>();
        bookIdSet.add(firstBookId);
        for (int bookId :
                otherBookIds) {
            bookIdSet.add(bookId);
        }
        // check if any book has been rented
        bookIdSet.forEach(bookId->{
            var theBook = books.get(bookId);
            if(theBook.getRentedBy()!=-1)
                throw new IllegalArgumentException("the book with id "+bookId +"has been rented");
        });
        // perform borrowing operation for the user
        var theUser = users.get(userId);
        bookIdSet.forEach(bookId->{
            // add the book to the user's borrowing list
            theUser.borrowBook(bookId);
            // set `rentedBy` of the book to user id
            var theBook = books.get(bookId);
            theBook.setRentedBy(userId);
        });
        System.out.println("finished borrowing books");
    }

    // return books
    public void returnBooks(int userId, int firstBookId, int ...otherBookIds){
        // validate userId and bookId(s) first before performing borrow operation
        if(!users.containsKey(userId) || !(0 <=firstBookId && firstBookId < books.size()))
            throw new IllegalArgumentException("invalid user id or book id");
        for (int id : otherBookIds) {
            System.out.println("book id: "+id);
            if (!(0 <= id && id < books.size()))
                throw new IllegalArgumentException("invalid book id");
        }
        // remove the duplicates of bookId(s)
        Set<Integer> bookIdSet = new HashSet<>();
        bookIdSet.add(firstBookId);
        for (int bookId :
                otherBookIds) {
            bookIdSet.add(bookId);
        }
        // check if any book has been returned
        bookIdSet.forEach(bookId->{
            var theBook = books.get(bookId);
            if(theBook.getRentedBy()==-1)
                throw new IllegalArgumentException("the book with id "+bookId+" has been returned");
        });
        //perform returning operation for the user
        var theUser = users.get(userId);
        bookIdSet.forEach(bookId->{
            // remove the book from the user's borrowing list
            theUser.returnBook(bookId);
            // reset the `rentedBy` of the book to -1
            var theBook = books.get(bookId);
            theBook.unrent();
        });
        System.out.println("finished returning operation");
    }

    public int getCurrentBookId() {
        return currentBookId;
    }

    public int getCurrentUserId() {
        return currentUserId;
    }
}
