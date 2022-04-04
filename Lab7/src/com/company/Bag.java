package com.company;

import java.util.*;

public class Bag {
    private final List<Tile> tiles = new ArrayList<>();

    public Bag(){
        for(char c = 'a'; c < 'z'; c++){
            int val = (int) ((Math.random() * (10 - 1)) + 1);
            Tile tile = new Tile(c,val,10);
            tiles.add(tile);
        }
    }

    public synchronized List<Tile> extractTiles(int howMany){
        List<Tile> extracted = new ArrayList<>();
        for(int i=0;i<howMany;i++){
            if(tiles.get(i).getCount() != 0){
                break;
            }
            extracted.add(tiles.get(i));
            tiles.get(i).decCount();
        }
        return extracted;
    }
}
