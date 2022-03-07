package com.company;

import java.util.Arrays;

public class Solution {
    private Problem pb;
    private Room[] assignement;
    private Room[] rooms;
    private Event[] events;
    private int matrix[][];
    private int count;

    public Solution(Problem problem) {
        this.pb = problem;
        this.rooms = pb.getRooms();
        this.events = pb.getEvents();
        this.count = pb.getNumberOfEvents();
        this.assignement = new Room[count];
        this.matrix = new int[pb.getNumberOfEvents()][pb.getNumberOfRooms()];
    }

    public boolean computeUsedRoom(int room, int event) {
        if (this.matrix[event][room] == 1) {
            return false;
        } else {
            for (int i = 0; i < pb.getNumberOfRooms(); i++) {
                this.matrix[event][i] = 1;
            }
            return true;
        }
    }

    public void Algorithm() {
        while (count > 0) {
            for (int i = 0; i < pb.getNumberOfEvents(); i++) {
                for (int j = 0; j < pb.getNumberOfRooms(); j++) {
                    if (events[i].getSize() <= rooms[j].getCapacity()) {
                        assignement[i] = rooms[j];
                        if (computeUsedRoom(j, i)) {
                            count--;
                            break;
                        }

                    }

                }
            }
        }
    }

    @Override
    public String toString() {
        String info = "";
        for (int i = 0; i < pb.getNumberOfEvents(); i++) {
            info += events[i].getName() + " -> " + assignement[i].getName() + "\n";
        }
        return info;
    }
}
