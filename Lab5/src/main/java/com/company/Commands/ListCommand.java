package com.company.Commands;

import com.company.Items.Catalog;

public class ListCommand extends Command{
    public ListCommand(String type, Catalog cat) {
        super(type, cat);
    }

    public static void list(Catalog cat){
        var items = cat.getItems();
        System.out.println(cat.getName());
        items.forEach(System.out::println);
    }
}
