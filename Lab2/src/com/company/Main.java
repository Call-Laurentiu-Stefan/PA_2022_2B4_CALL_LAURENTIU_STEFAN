package com.company;


public class Main {

    public static void main(String[] args) {
        Event even1 = new Event("C1", 100, 8, 10);
        Event event2 = new Event("C2", 100, 10, 12);
        Event event3 = new Event("L1", 30, 8, 10);
        Event event4 = new Event("L2", 30, 8, 10);
        Event event5 = new Event("L3", 30, 10, 12);
        Room r401 = new Room("401",RoomType.COMPUTER_HALL,30);
        Room r403 = new Room("403",RoomType.COMPUTER_HALL,30);
        Room r405 = new Room("405",RoomType.COMPUTER_HALL,30);
        Room r309 = new Room("309",RoomType.LECTURE_HALL,100);
        System.out.println("Events: " + even1 + event2 + event3 + event4 + event5);
        System.out.println("Rooms: " + r401 + r403 + r405 + r309);

    }
}
