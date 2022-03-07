package com.company;

import javax.xml.stream.Location;

public class Computer extends Node implements Identifiable, Storage {
    private int storageCapacity;

    public Computer(String address, int storageCapacity, String name) {
        this.address = address;
        super.setAddress(address);
        this.storageCapacity = storageCapacity;
        super.setName(name);
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public int getStorageCapacity() {
        return storageCapacity;
    }


}
