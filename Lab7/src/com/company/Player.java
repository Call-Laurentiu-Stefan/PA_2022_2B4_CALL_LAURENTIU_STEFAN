package com.company;

import java.util.List;

public class Player implements Runnable{

    private String name;
    private Game game;
    private boolean running;

    public Player(String name){
        this.name = name;
    }

    private boolean submitWord(String word) throws InterruptedException {
        List<Tile> extracted = game.getBag().extractTiles(7);
        if (extracted.isEmpty()) {
            return false;
        }
        game.getBoard().addWord(this, word);
        wait(50);
        return true;
    }
    public String getName(){
        return name;
    }


    @Override
    public void run() {

    }

    public void setGame(Game game) {
        this.game = game;
    }
}
