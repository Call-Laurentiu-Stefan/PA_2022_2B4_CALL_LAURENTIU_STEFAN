package com.company;

import javax.xml.stream.Location;

public class Switch extends Node implements Identifiable {
    private String address;


    public Switch(String address, String name) {
        this.address = address;
        super.setAddress(address);
        super.setName(name);
    }

    @Override
    public String getAddress() {
        return address;
    }


}
