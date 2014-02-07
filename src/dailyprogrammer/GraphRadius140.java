package dailyprogrammer;

import java.util.ArrayList;
import java.util.Scanner;

/** Graph Radius 140
 *  In graph theory, a graph's radius is the minimum eccentricity of any vertex for a given
 *  graph. More simply: it is the minimum distance between all possible pairs of vertices in a graph.
 *  As an example, the Petersen graph has a radius of 2 because any vertex is connected to any other vertex within 2 edges.
 *  On the other hand, the Butterfly graph has a radius of 1 since its middle vertex can connect to 
 *  any other vertex within 1 edge, which is the smallest eccentricity of all vertices in this set. Any 
 *  other vertex has an eccentricity of 2
 * 
 *  On standard console input you will be given an integer N, followed by an Adjacency matrix. The graph 
 *  is not directed, so the matrix will always be reflected about the main diagonal.
 * 
 *  Print the radius of the graph as an integer.
 * 
 *	Sample Input:
 *  10
 *  0 1 0 0 1 1 0 0 0 0
 *  1 0 1 0 0 0 1 0 0 0
 *  0 1 0 1 0 0 0 1 0 0
 *  0 0 1 0 1 0 0 0 1 0
 *  1 0 0 1 0 0 0 0 0 1
 *  1 0 0 0 0 0 0 1 1 0
 *  0 1 0 0 0 0 0 0 1 1
 *  0 0 1 0 0 1 0 0 0 1
 *  0 0 0 1 0 1 1 0 0 0
 *  0 0 0 0 1 0 1 1 0 0
 *  Sample Output:
 *  2
 *
 *
 *
 */

public class GraphRadius140 {
	private ArrayList<Integer> conNod = new ArrayList<Integer>();

	public GraphRadius140() {
	}

	protected void init(){
		Scanner scan = new Scanner(System.in);
		String pocetstring = scan.nextLine();
		int pocet = Integer.parseInt(pocetstring) - 1;
		String temp[] = new String[pocet];
		int matica[][] =  new int[pocet][pocet];
		for (int i = 0; i < pocet; i++) {
			temp= scan.nextLine().split("\\s");
			for (int x = 0; x < pocet; x++) {
				matica[i][x] = Integer.parseInt(temp[x]);
			}
		}
		System.out.println(vyhodnotenie(pocet,matica));		
	}
	
	protected int vyhodnotenie(int pocet, int matica[][]){
		int output = 0;
		boolean nasiel= false;
		for (int skumanaNoda = 0; skumanaNoda < pocet; skumanaNoda++) {
			for (int cielovaNoda = 0; cielovaNoda < pocet; cielovaNoda++) {
				if (skumanaNoda == cielovaNoda || matica[skumanaNoda][cielovaNoda] == 1) continue;
				int pocetKrokov = 0;
				conNod.add(skumanaNoda);

				while (!nasiel){	
					
					conNod = conectedNodes(matica, conNod);			
					if (chceckFinalNode(cielovaNoda, matica, conNod)) nasiel = true;
					pocetKrokov++;
				}
				conNod.clear();
				nasiel = false;
				if (pocetKrokov > output) output = pocetKrokov;
			}
		}
		return output;
	}
	
	
	protected ArrayList<Integer> conectedNodes(int[][] matica, ArrayList<Integer> conectionlist){
		ArrayList<Integer> tempconection =  new ArrayList<Integer>();
		for (Integer integer : conectionlist) {
			for (int i = 0; i < matica.length; i++) {
				if (matica[integer][i] == 1) tempconection.add(i);
			}
		}
		return tempconection;
	}
	
	protected boolean chceckFinalNode(int cielovaNoda,int[][] matica,ArrayList<Integer> conectionlist){
		for (Integer integer : conectionlist) {
			   if (matica[integer][cielovaNoda] == 1) return true;
		}
		return false;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GraphRadius140 gr140 = new GraphRadius140();
		gr140.init();

	}
}
