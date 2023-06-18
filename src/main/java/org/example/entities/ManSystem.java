package org.example.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ManSystem {
    public List<Book> books;
    private int currentBookId;
//    public List<User> users;
    public HashMap<Integer, User> users ;
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

    public int getCurrentBookId() {
        return currentBookId;
    }

    public int getCurrentUserId() {
        return currentUserId;
    }
}
