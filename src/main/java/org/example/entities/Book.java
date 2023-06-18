package org.example.entities;

public class Book {
    private int id;
    private String name;

    private int rentedBy;

    public int getRentedBy() {
        return rentedBy;
    }

    public void setRentedBy(int rentedBy) {
        this.rentedBy = rentedBy;
    }
    public void unrent(){
        this.rentedBy = -1;
    }

    public Book(int id, String name) {
        this.id = id;
        this.name = name;
        this.rentedBy = -1; // default -1 meaning no one rents this book yet.
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

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rentedBy=" + rentedBy +
                '}';
    }
}
