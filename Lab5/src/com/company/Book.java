package com.company;

public class Book extends Item{
    public Book(String title, String location) {
        super(title, location, ItemType.BOOK);
    }
}
