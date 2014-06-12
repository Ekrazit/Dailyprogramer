package dailyprogrammer;

import java.util.Scanner;

public class ASCIIGameofLife165 {
	
	private String[][] matrix;
	private int iretations = 0;

	public ASCIIGameofLife165() {
		init();
		step(matrix);
		printMatrix(matrix);
	}

	private void step(String[][] matrix2) {
		for (int row = 0; row < matrix2.length; row++) {
			for (int col = 0; col < matrix2[0].length; col++) {
				
			}
		}
		
	}

	private void printMatrix(String[][] matrix2) {
		for (int row = 0; row < matrix2.length; row++) {
			for (int col = 0; col < matrix2[0].length; col++) {
				System.out.println(matrix[row][col]);
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
			matrix[i] = scan.nextLine().split("\\s+");
		}
		
		
	}

	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new ASCIIGameofLife165();

	}

}
