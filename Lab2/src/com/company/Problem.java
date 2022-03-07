package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;

public class Problem {
    private int numberOfEvents, numberOfRooms;
    private Event[] events;
    private Room[] rooms;

    public Problem() {
        try {
            File eventFile = new File("events.txt");
            File roomsFile = new File("rooms.txt");
            Scanner eventScan = new Scanner(eventFile);
            numberOfEvents = eventScan.nextInt();
            String space = eventScan.nextLine();
            events = new Event[numberOfEvents];
            for (int i = 0; i < numberOfEvents; i++) {
                events[i] = new Event(eventScan.next(), eventScan.nextInt(), eventScan.nextInt(), eventScan.nextInt());
                space = eventScan.nextLine();
            }
            eventScan.close();
            Scanner roomScan = new Scanner(roomsFile);
            numberOfRooms = roomScan.nextInt();
            space = roomScan.nextLine();
            rooms = new Room[numberOfRooms];
            for (int i = 0; i < numberOfRooms; i++) {
                String name = roomScan.next();
                int cap = roomScan.nextInt();
                String type = roomScan.next();
                if (Objects.equals(type, "lab")) {
                    rooms[i] = new ComputerLab(name, cap);
                } else {
                    rooms[i] = new LectureHall(name, cap);
                }
                space = roomScan.nextLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        String info = "";
        info += "Number of events: " + numberOfEvents + "\n";
        for (int i = 0; i < numberOfEvents; i++) {
            info += events[i].getName() + "(size=" + events[i].getSize() + ", start=" + events[i].getStart() + ", end=" + events[i].getEnd() + ")\n";
        }
        info += "Number of rooms: " + numberOfRooms + "\n";
        for (int i = 0; i < numberOfRooms; i++) {
            info += rooms[i].getName() + "(cap=" + rooms[i].getCapacity() + ", " + rooms[i].getType() + ")\n";
        }

        return info;
    }

    public int getNumberOfEvents() {
        return numberOfEvents;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public Event[] getEvents() {
        return events;
    }

    public Room[] getRooms() {
        return rooms;
    }
}
