package com.company;

public class Main {

    public static void main(String[] args) {
	    Game game = new Game();
        game.addPlayer(new Player("Player1"));
        game.addPlayer(new Player("Player2"));
        game.addPlayer(new Player("Player3"));
        game.play();
    }
}
