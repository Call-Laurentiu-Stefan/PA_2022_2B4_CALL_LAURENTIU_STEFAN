package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

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

    public int compareByAddress(Node other){
        return (this.address.compareTo(other.address));
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

    @Override
    public String toString() {
        return address;
    }

    @Override
    public int hashCode(){
        return Objects.hash(address,cost);
    }
}
