package com.company;

import javax.xml.stream.Location;

public class Router extends Node implements Identifiable {

    public Router(String address, String name) {
        super.setAddress(address);
        super.setName(name);
    }

    @Override
    public String getAddress() {
        return address;
    }

}
