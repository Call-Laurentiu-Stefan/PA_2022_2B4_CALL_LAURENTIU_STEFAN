package com.company;

import java.util.ArrayList;
import java.util.List;

public class Network {
    private List<Node> nodes;
    private int numberOfNodes;

    public Network() {
        nodes = new ArrayList<>();
        numberOfNodes = 0;
    }

    public void addNode(Node node) {
        nodes.add(node);
        numberOfNodes++;
    }

    @Override
    public String toString() {
        String build = "";
        System.out.println("locations are : ");
        for (Node n : nodes) {
            build += n.getAddress() + "(" + n.getName() + ") ";
        }
        return build;
    }
}
