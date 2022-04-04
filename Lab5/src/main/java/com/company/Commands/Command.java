package com.company.Commands;

import com.company.Items.Catalog;
import com.company.Items.Item;

public abstract class Command {
    String type;
    Catalog cat;
    Item item;

    public Command(String type, Catalog cat, Item item){
        this.type = type;
        this.cat = cat;
        this.item = item;
    }

    public Command (String type, Catalog cat){
        this.type = type;
        this.cat = cat;
    }
}
