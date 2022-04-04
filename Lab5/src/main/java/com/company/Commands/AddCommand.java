package com.company.Commands;

import com.company.Items.Catalog;
import com.company.Items.Item;

public class AddCommand extends Command{

    public AddCommand(String type, Catalog cat, Item item) {
        super(type, cat, item);
    }

    public static void add(Catalog cat, Item item){
        var items = cat.getItems();
        items.add(item);
        cat.setItems(items);
    }
}
