package com.company;

import java.util.Collection;

public class Main {

    public static void main(String[] args) {
        Network network = new Network();
        Node v1 = new Computer("v1", 10,StorageType.MEGABYTE, "Computer A");
        network.addNode(v1);
        Node v2 = new Router("v2", "Router A");
        network.addNode(v2);
        Node v3 = new Switch("v3", "Switch A");
        network.addNode(v3);
        Node v4 = new Switch("v4", "Switch B");
        network.addNode(v4);
        Node v5 = new Router("v5", "Router B");
        network.addNode(v5);
        Node v6 = new Computer("v6", 100,StorageType.KILOBYTE, "Computer B");
        network.addNode(v6);

        v1.setCost(v2,10);
        v1.setCost(v3,50);
        v2.setCost(v3,20);
        v2.setCost(v4,20);
        v2.setCost(v5,10);
        v3.setCost(v4,20);
        v4.setCost(v5,30);
        v4.setCost(v6,10);
        v5.setCost(v6,20);

        System.out.println(network);
        network.indentifiableNodes();
    }
}
