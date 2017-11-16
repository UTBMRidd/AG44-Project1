package fr.cedric.utils;

import java.util.ArrayList;

import fr.cedric.components.Graph;
import fr.cedric.components.Node;

public class Dijkstra {
	
	public static void longestPath(Graph g, int start, int end){
		int length = g.getLength();
		int inf = 100;
		ArrayList<Integer> list = new ArrayList<Integer>();
		int[] weight = new int[length];
		int[] pred = new int[length];
		for(int i=0;i<length;i++){
			weight[i] = inf;
			pred[i] = -1;
		}
		weight[start] = 0;
		pred[start] = -1;
		list.add(start);
		while(!list.isEmpty()){
			int index = getMax(list, weight);
			Node n = g.getNode(index);
			list.remove(new Integer(index));
			for(Integer s : n.getSuccessors() ){
				int nW = weight[index] + 1;
				if(weight[s] < nW){
					weight[s] = nW;
					pred[s] = index;
				}
				list.add(s);
			}
		}
		int i = end;
		System.out.print("Sortie < " + i + " < ");
		while(pred[i] != -1){
			i = pred[i];
			System.out.print(i + " < ");

		}
		System.out.print(start + " < Entrée");
		
		
	}
	private static int getMax(ArrayList<Integer> list, int[] weight){
		int min = list.get(0);
		for(int i=1;i<list.size();i++){
			if(weight[min]<weight[list.get(i)]){
				min = list.get(i);
			}
		}
		return min;
	}
	

}
