package fr.cedric.main;

import fr.cedric.components.Graph;
import fr.cedric.components.Groups;
import fr.cedric.loader.fileLoader;
import fr.cedric.utils.Dijkstra;
import fr.cedric.utils.Tarjan;

public class Main {

	public static void main(String[] args) {
		Graph g = fileLoader.loadGraphFromFile("res/test.txt");
		g.printGraph();
		Tarjan t = new Tarjan();
		Groups gr = new Groups(g, t.tarjan(g));
		gr.printGroups();
		gr.printMatrix();
		System.out.println("");
		Graph grp = gr.getGraph();
		grp.printGraph();
		System.out.println("");
		Dijkstra.longestPath(grp, 4, 0);
	}

}
