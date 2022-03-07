package com.company;

public class Main {

    public static void main(String[] args) {
        Network network = new Network();
        Node v1 = new Computer("v1", 10, "Computer A");
        network.addNode(v1);
        Node v2 = new Router("v2", "Router A");
        network.addNode(v2);
        Node v3 = new Switch("v3", "Switch A");
        network.addNode(v3);
        Node v4 = new Switch("v4", "Switch B");
        network.addNode(v4);
        Node v5 = new Router("v5", "Router B");
        network.addNode(v5);
        Node v6 = new Computer("v6", 100, "Computer B");
        network.addNode(v6);
        System.out.println(network);
    }
}
