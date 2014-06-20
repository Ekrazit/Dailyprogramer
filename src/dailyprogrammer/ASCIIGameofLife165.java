/*	 ASCII Game of Life
 * 
 *  Sample Input
7 10 10
..........
..........
..#.......
...#......
.###......
..........
..........
..........
..........
..........

 */

package dailyprogrammer;

import java.util.Scanner;

public class ASCIIGameofLife165 {
	
	private String[][] matrix;
	private int iretations = 1;

	public ASCIIGameofLife165() {
		init();
		for (int i = 0; i < iretations; i++) {
			this.matrix = step(matrix);	
		} 
		 
		printMatrix(matrix);
	}

	private String[][] step(String[][] matrix2) {		
		
		for (int row = 0; row < matrix2[0].length; row++) {
			for (int col = 0; col < matrix2.length; col++) {
				
				int activecells = 0;
				for (int comprow = -1; comprow < 2; comprow++){
					for (int compcol = -1; compcol < 2; compcol++) {
						int temprow;
						if (row + comprow < 0) temprow = matrix2[0].length - 1;
						else temprow = row - comprow; 
						int tempcol;
						if (col + compcol < 0) tempcol = matrix2.length -1;
						else tempcol = col - compcol; 
						if(matrix2[temprow][tempcol].equals("#"))
							activecells++;
						
					}
				}
					
				if (activecells < 2) matrix2[row][col] = ".";
				if (activecells == 3) matrix2[row][col] = "#";
				if (activecells > 3) matrix2[row][col] = ".";
			
			}
		
		}

		return matrix2;
		
	}

	private void printMatrix(String[][] matrix2) {
		for (int row = 0; row < matrix2.length; row++) {
			for (int col = 0; col < matrix2[0].length; col++) {
				System.out.print(matrix[row][col]);
			}
			System.out.println(" ");
		}
	}

	private void init() {
		Scanner scan = new Scanner(System.in);
		String[] pocetString = scan.nextLine().split("\\s+");
		iretations = Integer.valueOf(pocetString[0]);
		int maticaX = Integer.valueOf(pocetString[1]);
		int maticaY = Integer.valueOf(pocetString[2]);
		matrix = new String[maticaX][maticaY];

		for (int i = 0; i < maticaX; i++) {
			matrix[i] = scan.nextLine().split("(?!^)");
		}
		
		
	}

	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new ASCIIGameofLife165();

	}

}
