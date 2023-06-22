package org.example.entities;

import java.util.*;

public class ManSystem {
    private List<Book> books;

    public List<Book> getBooks() {
        return books;
    }

    private int currentBookId;

    public HashMap<Integer, User> getUsers() {
        return users;
    }

    //    public List<User> users;
    private HashMap<Integer, User> users;
    private int currentUserId;

    public ManSystem() {
        this.books = new ArrayList<>();
        this.currentBookId = 0;
//        this.users = new ArrayList<>();
        this.users = new HashMap<>();
        this.currentUserId = 0;
    }

    // create and add a new user
    public User createUser(String username){
        int userId = currentUserId++;
        return new User(userId, username);
    }
    public void addUser(User user){
        users.put(user.getId(),user);
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
    public void borrowBooks(Integer userId, Integer firstBookId, Integer ...otherBookIds){
        // validate userId and bookId(s) first before performing borrow operation
        if(!users.containsKey(userId)) throw new IllegalArgumentException("invalid user id");
        validateNum(books.size(),firstBookId,otherBookIds);
        // remove the duplicates of bookId(s)
        Set<Integer> bookIdSet = generateSet(firstBookId,otherBookIds);

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
    public void returnBooks(Integer userId, Integer firstBookId, Integer ...otherBookIds){
        // validate userId and bookId(s) first before performing borrow operation
        if(!users.containsKey(userId)) throw new IllegalArgumentException("invalid user id");
        validateNum(books.size(),firstBookId,otherBookIds);
        // remove the duplicates of bookId(s)
        Set<Integer> bookIdSet = generateSet(firstBookId,otherBookIds);

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

    private Set<Integer> generateSet(Integer first,Integer ...others){
        Set<Integer> newSet = new HashSet<>();
        newSet.add(first);
        newSet.addAll(Arrays.asList(others));
        return newSet;
    }

    private void validateNum(Integer range, Integer first, Integer[] others){
        Integer[] arr = new Integer[others.length+1];
        arr[0] = first;
        System.arraycopy(others,0,arr,1,others.length);
        for (Integer integer : arr) {
            if (integer < 0 || integer >= range)
                throw new IllegalArgumentException("invalid num");
        }
    }

    public int getCurrentBookId() {
        return currentBookId;
    }

    public int getCurrentUserId() {
        return currentUserId;
    }
}
