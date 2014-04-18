package dailyprogrammer;

import java.util.Scanner;

public class TheWinningMoveXGamesedition157 {
	private String move;
	private String grid[][] = new String[3][3];
	private int row;
	private int column;

	public TheWinningMoveXGamesedition157() {

	}

	public void init() {
		Scanner scan = new Scanner(System.in);
		move = scan.nextLine();
		for (int x = 0; x < 3; x++) {
			grid[x] = scan.nextLine().split("(?!^)");
		}
		if (checkrow(move, grid) != -1) {
			grid[row][column] = move;
			draw(grid);
			return;
		}
		if (checkcolumn(move, grid) != -1) {
			grid[row][column] = move;
			draw(grid);
			return;
		}
		if (checkDiagonal(move, grid) != -1) {
			grid[row][column] = move;
			draw(grid);
			return;
		}
		System.out.println("No Winning Move!");
	}

	public int checkrow(String move, String grid[][]) {

		for (int i = 0; i < grid.length; i++) {
			int pocetmove = 0;
			int pocetprazdnych = 0;
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j].equals(move))
					pocetmove++;
				if (grid[i][j].equals("-")) {
					pocetprazdnych++;
					row = i;
					column = j;
				}
			}
			if (pocetmove == 2 && pocetprazdnych == 1)
				return i;

		}
		return -1;
	}

	public int checkcolumn(String move, String grid[][]) {
		for (int i = 0; i < grid.length; i++) {
			int pocetmove = 0;
			int pocetprazdnych = 0;
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[j][i].equals(move))
					pocetmove++;
				if (grid[j][i].equals("-")) {
					pocetprazdnych++;
					row = j;
					column = i;
				}
			}
			if (pocetmove == 2 && pocetprazdnych == 1)
				return i;

		}
		return -1;
	}

	public int checkDiagonal(String move, String grid[][]) {
		int pocetmove = 0;
		int pocetprazdnych = 0;
		for (int i = 0; i < grid.length; i++) {
			if (grid[i][i].equals(move))
				pocetmove++;
			if (grid[i][i].equals("-")) {
				pocetprazdnych++;
				row = i;
				column = i;
			}
		}

		if (pocetmove == 2 && pocetprazdnych == 1)
			return 1;
		pocetmove = 0;
		pocetprazdnych = 0;
		int j = grid.length - 1;
		for (int i = 0; i < grid.length; i++) {
			if (grid[i][j].equals(move))
				pocetmove++;
			if (grid[i][j].equals("-")) {
				pocetprazdnych++;
				row = i;
				column = j;
			}
			j--;
		}

		if (pocetmove == 2 && pocetprazdnych == 1)
			return 1;

		return -1;
	}

	public void draw(String grid[][]) {
		for (String[] strings : grid) {
			for (String string : strings) {
				System.out.print(string);
			}
			System.out.println("");
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new TheWinningMoveXGamesedition157().init();

	}

}
