package com.company;

import java.util.HashMap;
import java.util.Map;

public abstract class Node implements Comparable<Node> {
    private String address;
    private String name;
    private Map<Node, Integer> cost = new HashMap<>();

    public void setCost(Node n, int value) {
        cost.put(n, value);
    }

    public Map<Node, Integer> getMap() {
        return cost;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public int compareTo(Node other) {
        if (this.name == null && other.name == null) {
            return 0;
        } else if (this.name == null) {
            return -1;
        } else if (other.name == null) {
            return 1;
        } else {
            return this.name.compareTo(other.name);
        }
    }
}
