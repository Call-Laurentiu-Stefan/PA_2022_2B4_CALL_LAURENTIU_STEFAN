package com.company;

import javax.xml.stream.Location;

public class Computer extends Node implements Identifiable, Storage {
    private int storageCapacity;
    StorageType type;

    public Computer(String address, int storageCapacity, StorageType type, String name) {
        super.setAddress(address);
        this.storageCapacity = storageCapacity;
        this.type = type;
        super.setName(name);
    }

    @Override
    public String getStorageCapacity() {
        return String.valueOf(storageCapacity) + " " + String.valueOf(type);
    }


}
