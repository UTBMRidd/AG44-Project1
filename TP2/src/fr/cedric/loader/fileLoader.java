package fr.cedric.loader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import fr.cedric.components.Graph;

public class fileLoader {
	
	public static Graph loadGraphFromFile(String fileName){
		
		BufferedReader br = null;
		FileReader fr = null;
		int line = 0;
		Graph g = new Graph();

		try {
			fr = new FileReader(fileName);
			br = new BufferedReader(fr);

			String sCurrentLine;

			while ((sCurrentLine = br.readLine()) != null) {
				line++;
				String [] tokens = sCurrentLine.split(" ");
				ArrayList<Integer> s = new ArrayList <Integer>();
				for(int i=0;i<tokens.length;i++){
					if(Integer.parseInt(tokens[i]) == 1){
						s.add(i+1);
					}

				}
				g.addNode(line, s);
			}

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (br != null)
					br.close();

				if (fr != null)
					fr.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}

		return g;
		
	}

}
