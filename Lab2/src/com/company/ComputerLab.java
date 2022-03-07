package com.company;

import java.util.Random;

public class ComputerLab extends Room {
    String os;
    String types[] = new String[]{"Linux", "Windows", "Mac"};

    public ComputerLab(String name, int cap) {
        super(name, RoomType.COMPUTER_HALL, cap);
        Random rand = new Random();
        os = types[rand.nextInt(3)];
    }

    public String getOs() {
        return os;
    }
}
