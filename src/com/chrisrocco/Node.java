package com.chrisrocco;

import java.util.ArrayList;

public class Node<DataType> {
    private int id;
    DataType data;
    public ArrayList<Edge> inbound = new ArrayList<Edge>();
    public ArrayList<Edge> outbound = new ArrayList<Edge>();

    public Node(int id, DataType data) {
        this.id = id;
        this.data = data;
    }

    public void addInbound(Edge edge) {
        inbound.add(edge);
    }

    public void addOutbound(Edge edge) {
        outbound.add(edge);
    }

    public int getID(){
        return id;
    }

    public String toString() {
        return String.format("id:%s ( %s )", id, data);
    }
}
