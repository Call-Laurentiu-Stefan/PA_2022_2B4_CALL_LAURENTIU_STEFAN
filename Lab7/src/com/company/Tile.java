package com.company;

public class Tile {
    private final char letter;
    private final int points;
    private int count;

    public Tile(char letter, int points, int count) {
        this.letter = letter;
        this.points = points;
        this.count = count;
    }

    public char getLetter() {
        return letter;
    }

    public int getPoints() {
        return points;
    }

    public int getCount(){
        return count;
    }

    public void decCount(){
        count = count - 1;
    }

    @Override
    public String toString() {
        return "Tile{" +
                "letter=" + letter +
                ", points=" + points +
                '}';
    }
}
