package com.company;

public abstract class Room {
    private String name;
    private RoomType type;
    private int capacity;

    public Room() {
    }

    public Room(String name, RoomType type, int capacity) {
        this.name = name;
        this.type = type;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RoomType getType() {
        return type;
    }

    public void setType(RoomType type) {
        this.type = type;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return name + "(" +
                "cap=" + capacity +
                ", " + type +
                "), ";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Room)) {
            return false;
        }
        Room other = (Room) obj;
        return name.equals(other.name);
    }

}
