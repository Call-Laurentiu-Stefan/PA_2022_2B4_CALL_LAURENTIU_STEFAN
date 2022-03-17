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
    public void indentifiableNodes(){
        List<Node> newNodes = new ArrayList<>();
        for(Node node : nodes){
            if (node instanceof Identifiable){
                newNodes.add(node);
            }
        }
        System.out.println("List of identifiable nodes: ");
        newNodes.sort(Node::compareByAddress);
        for(Node node : newNodes){
            System.out.println(node + " ");
        }
        System.out.println();
    }


    public void sortNodes() {
        nodes.sort(Node::compareTo);
    }

    @Override
    public String toString() {
        String build = "";
        for (Node n : nodes) {
            build += n.getAddress() + "" + n.getMap()+ "\t" + n.getMap().values() +"\n";
        }
        return build;
    }
}
