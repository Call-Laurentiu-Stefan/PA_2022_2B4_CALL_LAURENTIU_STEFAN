package com.company.Items;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public abstract class Item implements Serializable {
    private String id;
    private String title;
    private String location;
    private ItemType type;
    private Map<String, Object> tags = new HashMap<>();


    public Item(String title, String location, ItemType type) {
        this.title = title;
        this.location = location;
        this.type = type;
        id = UUID.randomUUID().toString();
        tags.put(id,this);
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public ItemType getType() {
        return type;
    }

    public void addTag(String id, Item item){
        tags.put(id, item);
    }


    @Override
    public String toString() {
        return "{\"id\":" + '"' + id + "\", \"title\":" + '"' + title + "\", \"location\":" + '"' + location + "\", \"type\":" + '"' + type + "\"};";
    }
}