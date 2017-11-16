package fr.cedric.components;

import java.util.ArrayList;

public class Groups {
	
	
	ArrayList<ArrayList<Integer>> groups;
	int nbGr;
	int[][] matrix;
	
	public Groups(Graph g,ArrayList<ArrayList<Integer>> gr){
		this.groups = gr;
		nbGr = gr.size();
		this.matrix = new int[nbGr][nbGr];
		initMatrix(g,matrix);
	}
	private void initMatrix(Graph g, int[][] matrix){
		for(int i=1;i<=g.getLength();i++){
			Node n = g.getNode(i);
			for(Integer s : n.getSuccessors()){
				if(getGroup(i) != getGroup(s)){
					matrix[getGroup(i)-1][getGroup(s)-1] +=1;
				}
			}
		}
	}
	private int getGroup(int index){
		int Ngr =0;
		int Fgr = 0;
		for(ArrayList<Integer> gr : this.groups){
			Ngr += 1;
			for(Integer i : gr){
				if(i == index){
					Fgr = Ngr;
				}
			}
		}
		return Fgr;
	}
	public void printMatrix(){
		for (int i = 0; i < nbGr; i++) {
		    for (int j = 0; j < nbGr; j++) {
		        System.out.print(matrix[i][j] + " ");
		    }
		    System.out.println();
		}
	}
	public void printGroups(){
		int j = 1;
		for(ArrayList<Integer> gr : groups){
			System.out.println("Groupe " + j + " :");
			for(Integer i : gr){
				System.out.print(i + " ");
			}
			System.out.println("\nFin de groupe\n");
			j++;
		}
	}
	public Graph getGraph(){
		Graph g = new Graph();
		for(int i =0;i<nbGr;i++){
			ArrayList<Integer> succ = new ArrayList<Integer>();
			for(int j=0;j<nbGr;j++){
				if(matrix[i][j]>0){
					succ.add(j);
				}
			}
			g.addNode(i,succ);
		}
		return g;
	}
	
	
	

}
