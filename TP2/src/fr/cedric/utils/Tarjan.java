package fr.cedric.utils;

import java.util.ArrayList;
import java.util.Stack;

import fr.cedric.components.Graph;
import fr.cedric.components.Node;

public class Tarjan {
	
	private int index;
	public ArrayList<ArrayList<Integer>> tarjan(Graph g){
		ArrayList<ArrayList<Integer>> grps = new ArrayList<ArrayList<Integer>>();
		Stack<Node> stack = new Stack<Node>();
		int[] indx = new int[g.getLength()+ 1];
		int[] lowLink = new int[g.getLength()+ 1];
		boolean[] stk = new boolean[g.getLength()+ 1];
		for(int j =0;j<g.getLength();j++){
			indx[j+1] = -1;
			lowLink[j+1] = -1;
			stk[j+1] = false;
		}
		
		for(int i=0;i<g.getLength();i++){
			Node n = g.getNode(i+1);
			if(indx[n.getNodeID()] == -1){
				this.strongComponent(g, n, stack,grps,indx,lowLink,stk);
			}
		}
		return grps;
		
	}
	
	private void strongComponent(Graph g,Node n, Stack<Node> s,ArrayList<ArrayList<Integer>> grps,int[] indexT,int[] lowL,boolean[] stk){
		
		indexT[n.getNodeID()] = this.index;
		lowL[n.getNodeID()] = this.index;
		s.push(n);
		stk[n.getNodeID()] = true;
		
		this.index += 1;
		
		for(Integer i : n.getSuccessors()){
			Node w = g.getNode(i);
			if(indexT[w.getNodeID()] == -1){
				strongComponent(g,w,s,grps,indexT,lowL,stk);
				lowL[n.getNodeID()] = Math.min(lowL[n.getNodeID()], lowL[w.getNodeID()]);
			}
			else if(stk[w.getNodeID()]){
				
				lowL[n.getNodeID()] = Math.min(lowL[n.getNodeID()], lowL[w.getNodeID()]);
			}
		}
		if(lowL[n.getNodeID()] == indexT[n.getNodeID()]){
			Node w = null;
			ArrayList<Integer> gr = new ArrayList<Integer>();
			do{
				w = s.pop();
				stk[w.getNodeID()] = false;
				gr.add(w.getNodeID());
			}while(w != n);
			grps.add(gr);
		}
		
	}
	
	
}
