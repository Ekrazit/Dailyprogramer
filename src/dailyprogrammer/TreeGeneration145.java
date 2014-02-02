package dailyprogrammer;

import java.util.Scanner;

/**
 * Tree Generation 
 * You will be given one line of text on standard-console input:
 * an integer and two characters, all space-delimited. The integer, N, will
 * range inclusively from 3 to 21 and always be odd. The next character will be
 * your trunk character. The next character will be your leaves character. Draw
 * the trunk and leaves components with these characters, respectively. Sample
 * input :3 # * 
 * Sample output: 
 *   * 
 *  *** 
 *  ###
 */

public class TreeGeneration145 {

	public TreeGeneration145() {
		Scanner scan = new Scanner(System.in);
		String input[] = scan.nextLine().split("\\s");
		int pocet = Integer.parseInt(input[0]);
		for (int i = 0; i < pocet / 2 + 1; i++) {

			for (int x = 0; x < pocet / 2 - i; x++)
				System.out.print(" ");

			for (int x = 0; x < i * 2 + 1; x++)
				System.out.print(input[2]);

			System.out.println(" ");
		}

		for (int x = 0; x < pocet / 2 - 1; x++)
			System.out.print(" ");
		System.out.format("%s%s%s", input[1], input[1], input[1]);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeGeneration145 tr145 = new TreeGeneration145();
	}

}
