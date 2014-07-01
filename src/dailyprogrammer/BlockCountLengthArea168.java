package dailyprogrammer;

import java.util.Scanner;

/** Block Count, Length & Area 168
 * 
 * To keep this within our scope we have converted the plans into an ASCII picture.
 * We have scaled the plans so 1 character is a square with dimensions of 10 ft x 10 ft.
 * The photo is case sensitive. so a "O" and "o" are 2 different blocks of areas to compute.
 * Blocks Counts, Lengths and Areas:
 *  Some shorthand to follow:
    SF = square feet
    LF = linear feet
If you have the following picture.

####
OOOO
####
mmmm

    # has a block count of 2. we have 2 areas not joined made up of #
    O and m have a block count of 1. they only have 1 areas each made up of their ASCII character.
    O has 4 blocks. Each block is 100 SF and so you have 400 SF of O.
    O has a circumference length of that 1 block count of 100 LF.
    m also has 4 blocks so there is 400 SF of m and circumference length of 100 LF
    # has 2 block counts each of 4. So # has a total area of 800 SF and a total circumference length of 200 LF.

 * Pay close attention to how "#" was handled. It was seen as being 2 areas made up of # but the final
 * length and area adds them together even thou they not together. It recognizes the two areas by having
 * a block count of 2 (2 non-joined areas made up of "#" characters) while the others only have a block count of 1.
 * Input:
 * Your input is a 2-D ASCII picture. The ASCII characters used are any non-whitespace characters.
Example:

####
@@oo
o*@!
****

Output:

You give a Length and Area report of all the blocks.
Example: (using the example input)

Block Count, Length & Area Report
=================================

#: Total SF (400), Total Circumference LF (100) - Found 1 block
@: Total SF (300), Total Circumference LF (100) - Found 2 blocks
o: Total SF (300), Total Circumference LF (100) - Found 2 blocks
*: Total SF (500), Total Circumference LF (120) - Found 1 block
!: Total SF (100), Total Circumference LF (40) - Found 1 block


 */

public class BlockCountLengthArea168 {
	private String[][] matrix;

	public static void main(String[] args) {
		new BlockCountLengthArea168().init();
	}

	public BlockCountLengthArea168() {
	}

	private void init() {
		read();
		calculate();
		printresults();
	}

	private void printresults() {
		// TODO Auto-generated method stub
		
	}

	private void calculate() {
		// TODO Auto-generated method stub
		
	}

	private void read() {
		Scanner scan = new Scanner(System.in);
		while (scan.hasNextLine()){
			String[] nexline = scan.nextLine().split("(?!^)");
			if (nexline.length <=1) break;
			matrix = new String[nexline.length][nexline.length];
			for (int i = 0; i < nexline.length; i++) {
				matrix[i] = nexline;
			}
		}
	}

}


class block{
	
}