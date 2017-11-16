package fr.cedric.components;

import java.util.ArrayList;

public class Node {

	private int nodeID;
	private ArrayList<Integer> successors = new ArrayList <Integer>();
	
	public Node(int id, ArrayList<Integer> s){
		this.nodeID = id;
		this.successors = s;
	}
	
	
	public ArrayList<Integer> getSuccessors(){
		
		return this.successors;
	}
	public void setSuccessors(ArrayList<Integer> s){
		
		this.successors = s;
	}

	public int getNodeID() {
		return nodeID;
	}

	public void setNodeID(int nodeID) {
		this.nodeID = nodeID;
	}

	

}
