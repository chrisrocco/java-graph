package com.chrisrocco;

public class Edge<DataType> {
    private int id;
    public Node to;
    public Node from;
    DataType data;

    public Edge(int id, Node to, Node from, DataType data) {
        this.id = id;
        this.to = to;
        this.from = from;
        this.data = data;

        from.outbound.add(this);
        to.inbound.add(this);
    }
    public Edge(int id, Node to, Node from) {
        this.id = id;
        this.to = to;
        this.from = from;

        from.outbound.add(this);
        to.inbound.add(this);
    }

    public void removeReferences() {
        to.inbound.remove(this);
        from.outbound.remove(this);
    }

    public int getID(){
        return id;
    }

    @Override
    public String toString(){
        return String.format("id:%s %s --> %s", id, to, from);
    }
}
