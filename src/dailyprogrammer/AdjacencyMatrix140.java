package dailyprogrammer;

import java.util.Scanner;

/** Adjacency Matrix
 * 
 * On standard console input, you will be first given a line with two space-delimited integers N and M
 * . N is the number of nodes / vertices in the graph, while M is the number of following lines of
 * edge-node data. A line of edge-node data is a space-delimited set of integers, with the special "->" symbol 
 * indicating an edge. This symbol shows the edge-relationship between the set of left-sided integers and the
 * right-sided integers. This symbol will only have one element to its left, or one element to its right.
 * These lines of data will also never have duplicate information; you do not have to handle re-definitions
 * of the same edges.
 * An example of data that maps the node 1 to the nodes 2 and 3 is as follows:
 * 1 -> 2 3
 * 
 * Sample Input
 * 5 5
 * 0 -> 1
 * 1 -> 2
 * 2 -> 4
 * 3 -> 4
 * 0 -> 3
 * Sample Output
 * 01010
 * 00100
 * 00001
 * 00001
 * 00000
 *
 */
public class AdjacencyMatrix140 {

	public AdjacencyMatrix140() {
		// TODO Auto-generated constructor stub
	}
	
	protected void init(){
		Scanner scan = new Scanner(System.in);
		String pocetstring[] = scan.nextLine().split("\\s");
		int velkostMatice = Integer.parseInt(pocetstring[0]);
		int pocetRiadkov = Integer.parseInt(pocetstring[1]);
		
	
		int matica[][] =  new int[velkostMatice][velkostMatice];
		for (int i = 0; i < pocetRiadkov; i++) {
			String temp[]= scan.nextLine().split("\\s");
			int xOs = Integer.parseInt(temp[0]);
			int YOs = Integer.parseInt(temp[2]);
			matica[xOs][YOs] = 1;
		}
		for (int x = 0; x < velkostMatice; x++) {
			for (int y = 0; y < velkostMatice; y++) {
				System.out.print(matica[x][y]);
			}
			System.out.println("");
		}
				
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AdjacencyMatrix140 am140 = new AdjacencyMatrix140();
		am140.init();
	}

}
