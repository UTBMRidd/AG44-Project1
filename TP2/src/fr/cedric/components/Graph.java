package fr.cedric.components;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Graph {
	private HashMap<Integer,Node> nodes = new HashMap <Integer,Node>();
	private int length;
	
	public void addNode(int id, ArrayList<Integer> s){
		nodes.put(id, new Node(id, s));
		this.length += 1;
	}
	public Node getNode(int index){
		return nodes.get(index);
	}
	public void printGraph(){
		for(Map.Entry<Integer,Node> entry : nodes.entrySet()) {
		    int key = entry.getKey();
		    Node value = entry.getValue();
		    System.out.print("Node " + key  + " - Successors : {");
		    for(Integer i : value.getSuccessors()){
		    	System.out.print(i + " ");
		    }
		    System.out.print("}\n");
		}
		
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}

}
