package dailyprogrammer;

import java.util.ArrayList;
import java.util.Scanner;

/**Find the shortest path
 * Given an ASCII grid through standard console input, you must find the shortest path from 
 * the start to the exit (without walking through any walls). You may only move up, down,
 *  left, and right; never diagonally.
 * Author: liloboy
 * Formal Inputs & Outputs
 * Input Description
 * 
 * The first line of input is an integer, which specifies the size of the grid in both 
 * dimensions. For example, a 5 would indicate a 5 x 5 grid. The grid then follows on the 
 * next line. A grid is simply a series of ASCII characters, in the given size. You start at 
 * the 'S' character (for Start) and have to walk to the 'E' character (for Exit), without 
 * walking through any walls (indicated by the 'W' character). Dots / periods indicate open, 
 * walk-able space.
 * Output Description
 * 
 * The output should simply print "False" if the end could not possibly be reached or "True", 
 * followed by an integer. This integer indicates the shortest path to the exit.
 * Sample Inputs & Outputs
 * Sample Input:
 * 5
 * S....
 * WWWW.
 * .....
 * .WWWW
 * ....E
 * 
 *  Check out this link for many more examples! http://pastebin.com/QFmPzgaU
 *  Sample Output:
 *  True, 16
 * 
 */

public class Findtheshortestpath119 {
	private node start =  new node();
	private node end =  new node();

	public Findtheshortestpath119() {
		// TODO Auto-generated constructor stub
	}
	protected void init (){
		char matica[][] = nacitajMaticu();
		if (!skontrolujStartEnd(matica)) return;
		boolean hladaj = false;
		int pocetkrokov = 0;
		ArrayList<node> kdeUzBol = new ArrayList<node>();
		ArrayList<node> kamIde = new ArrayList<node>();
		ArrayList<node> krok = new ArrayList<node>();
		krok.add(start);
		while (!hladaj){
			for (node node : krok) {
				kamIde.addAll(najdiSusedov(matica, node));
				
			}
			for (node node:kamIde) if (node.isExit()) hladaj = true;
			krok.clear();
			krok.addAll(kamIde);
		
			for (node node : kdeUzBol) {
				if (krok.contains(node)) krok.remove(node);
			}
			kdeUzBol.addAll(krok);
			if (krok.isEmpty()) break;
			pocetkrokov++;
			kamIde.clear();
		}
		System.out.println(hladaj + ", " + pocetkrokov);
		
	}
	
	protected char[][] nacitajMaticu(){
		Scanner scan = new Scanner(System.in);
		int velkost = Integer.valueOf(scan.nextLine().trim());
		char matica[][] =  new char[velkost][velkost];
		for (int i = 0; i < velkost; i++) {
			char tempchar[] = scan.nextLine().toCharArray();
			System.arraycopy(tempchar, 0, matica[i], 0, velkost); //skopirovat len dlzku 
		}
		return matica;
	}
	
	protected ArrayList<node> najdiSusedov(char[][] matica, node bod){
		ArrayList<node> out = new ArrayList<node>();
		int susedia[][] = {{-1,0},{0,1},{0,-1},{1,0}}; 
		for (int[] sus: susedia) {
			if (bod.getX()+sus[0] < 0 || bod.getX() +sus[0] > matica.length -1) continue;
			if (bod.getY()+sus[1] < 0 || bod.getY() +sus[1] > matica.length -1) continue;
			if (matica[bod.getX() +sus[0]][bod.getY() +sus[1]] == '.') {
				node nd = new node();
				nd.setX(bod.getX() +sus[0]);
				nd.setY(bod.getY() +sus[1]);
				out.add(nd);
			}
			if (matica[bod.getX() +sus[0]][bod.getY() +sus[1]] == 'E') {
				node nd = new node();
				nd.setExit(true);
				nd.setX(bod.getX() +sus[0]);
				nd.setY(bod.getY() +sus[1]);
				out.add(nd);
			}
		}
	   return out;
	}
	
	
	protected boolean skontrolujStartEnd(char[][] matica){
		boolean start = false;
		boolean end = false;
		for (int i = 0; i < matica.length; i++) {
			for (int j = 0; j < matica.length; j++) {
			  if (matica[i][j] == 'S') {
				  if (start) return false;  // dvojity start&end check
				  start = true; 
				  this.start.setX(i);
				  this.start.setY(j);
			  }
			  if (matica[i][j] == 'E'){
				  if (end) return false;
				  end = true;
				  this.end.setX(i);
				  this.end.setY(j);
			  }
			}
		}
		return (start== true && end == true ) ? true : false;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Findtheshortestpath119 ftstp119 = new Findtheshortestpath119();
		ftstp119.init();
	}

}

class node {
	private int x;
	private int y;
	boolean exit = false;
	/**
	 * @param y the y to set
	 */
	protected void setY(int y) {
		this.y = y;
	}


	/**
	 * @return the x
	 */
	protected int getX() {
		return x;
	}


	/**
	 * @param x the x to set
	 */
	protected void setX(int x) {
		this.x = x;
	}


	/**
	 * @return the y
	 */
	protected int getY() {
		return y;
	}


	/**
	 * @return the exit
	 */
	protected boolean isExit() {
		return exit;
	}


	/**
	 * @param exit the exit to set
	 */
	protected void setExit(boolean exit) {
		this.exit = exit;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		node other = (node) obj;
		if (exit != other.exit)
			return false;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (exit ? 1231 : 1237);
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}
}
