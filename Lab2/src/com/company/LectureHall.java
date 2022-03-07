package com.company;

import java.util.Random;

public class LectureHall extends Room {
    boolean videoProjector;

    public LectureHall(String name, int cap) {
        super(name, RoomType.LECTURE_HALL, cap);
        Random random = new Random();
        videoProjector = random.nextBoolean();
    }

    public boolean isVideoProjector() {
        return videoProjector;
    }
}
