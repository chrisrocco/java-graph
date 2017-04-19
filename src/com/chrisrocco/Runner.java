package com.chrisrocco;

import java.util.Random;
import java.util.Stack;

public class Runner {

    static String[] nodeContents = {
            "Green",
            "Blue",
            "Yellow",
            "Red",
            "Orange",
            "Purple",
            "Grey",
            "Black",
            "White",
            "Maroon",
            "Brown",
    };

	public static void main(String[] args) {
		Random random = new Random();
		Graph graph = new Graph();

		int numVerticies = 20;
		Stack<Integer> ids = new Stack<>();
		for (int i = 0; i < numVerticies; i++) {
			 ids.push(graph.addVertex(nodeContents[random.nextInt(nodeContents.length-1)]));
		}
		
		int numEdges = numVerticies/2;
		for (int i = 0; i < numEdges; i++) {
			graph.addEdge(ids.pop(), ids.pop(), 20);
		}
		
		System.out.println(graph.toString());
	}
}
