package com.chrisrocco;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Graph<DataType> {
	
	private int uniqueID = 0;
	public Map<Integer, Edge> edges = new HashMap<Integer, Edge>();
	public Map<Integer, Node<DataType>> verticies = new HashMap<Integer, Node<DataType>>();


    public int addVertex(DataType data){
        return this.addVertex(new Node<DataType>(nextID(), data));
    }
    public int addEdge(int from_vertex, int to_vertex) {
        return addEdge(from_vertex, to_vertex, null);
    }

	private int addVertex(Node<DataType> node) {
		verticies.put(node.getID(), node);
		return node.getID();
	}
	public int addEdge(int from_vertex, int to_vertex, DataType data) {
		Node to = verticies.get(to_vertex);
		Node from = verticies.get(from_vertex);
		Edge edge = new Edge(nextID(), to, from);
		edges.put(edge.getID(), edge);
		return edge.getID();
	}


	private int nextID(){
        uniqueID++;
        return uniqueID;
    }

	public String toString() {
		String output = "";
		for (Map.Entry<Integer, Node<DataType>> vertex: verticies.entrySet()) {
			output += vertex.getValue().toString();
			ArrayList<Edge> outboundEdges = vertex.getValue().outbound;
			for (Edge outbound: vertex.getValue().outbound) {
				output += "\r\n\t";
				output += outbound;
			}
			output += "\r\n";
		}
		return output;
	}
}