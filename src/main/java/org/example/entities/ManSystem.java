package org.example.entities;

import java.util.ArrayList;
import java.util.List;

public class ManSystem {
    public List<Book> books;
    private int currentBookId;
    public List<User> users;
    private int currentUserId;

    public ManSystem() {
        this.books = new ArrayList<>();
        this.currentBookId = 0;
        this.users = new ArrayList<>();
        this.currentUserId = 0;
    }

    public int getCurrentBookId() {
        return currentBookId;
    }

    public int getCurrentUserId() {
        return currentUserId;
    }
}
