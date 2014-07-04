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
	private ArrayList<Block> blocks = new ArrayList<Block>();
	private ArrayList<String> blockPattern = new ArrayList<String>();

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
		int obvod = 0;
		int obsah = 0;
		int pocetblokov = 0;
		for (String pattern : blockPattern) {
			for (Block block : blocks) {
				if (block.getBlockPattern().equals(pattern)){
					obvod += block.getObvod();
					obsah += block.getPlocha();
					pocetblokov++;
				}
			}
			System.out.println(pattern + ": Total SF ("+ obsah  +"), Total Circumference LF ("+obvod+") - Found "+pocetblokov+" block");
		}
	}

	private void calculate() {
		for (int row = 0; row < this.matrix[0].length; row++) {
			for (int column = 0; column < this.matrix.length; column++) {
				if (blocks.size() == 0) {
					blocks.add(new Block(matrix[row][column]));
					blockPattern.add(matrix[row][column]);
				} else
					for (Block block : blocks) {
						if (matrix[row][column].equals(block.getBlockPattern())) {
//---------------						
							int merge = 0;
							if (isInMatrix(matrix, row - 1, column))
								if (matrix[row][column].equals(matrix[row - 1][column]))
									merge++;

							if (matrix[row][column].equals(matrix[row][column - 1]))
								merge++;

						}
				}
			}
		}

	}
	
	private void mergeBlocks(Block block1, Block block2){
				
	}
	
	private boolean isInMatrix(String[][] matrix, int row, int column){
		return false;
	}

	private void read() {
		Scanner scan = new Scanner(System.in);
		while (scan.hasNextLine()) {
			String[] nexline = scan.nextLine().split("(?!^)");
			if (nexline.length <= 1)
				break;
			matrix = new String[nexline.length][nexline.length];
			for (int i = 0; i < nexline.length; i++) {
				matrix[i] = nexline;
			}
		}
	}
}

class Block {

	private String blockPattern;

	ArrayList<Integer[]> bloky = new ArrayList<Integer[]>();

	Block(String blockPattern) {
		this.setBlockPattern(blockPattern);
	}
	Block(String blockPattern,ArrayList<Integer[]> bloky ) {
		this.setBlockPattern(blockPattern);
		this.bloky = bloky;
	}

	public int getPlocha() {
		return bloky.size() * 100;
	}

	public int getObvod() {
		int obvod = 0;
		for (Integer[] c : bloky) {
			if (!isPart(c[0] - 1, c[1]))
				obvod++;
			if (!isPart(c[0] + 1, c[1]))
				obvod++;
			if (!isPart(c[0], c[1] - 1))
				obvod++;
			if (!isPart(c[0], c[1] + 1))
				obvod++;
		}
		return obvod * 10;
	}

	public boolean isPart(int row, int column) {
		for (Integer[] c : bloky) {
			if (c[0] == 0 && c[1] == column)
				return true;
		}
		return false;
	}

	public void addblock(int row, int column) {
		bloky.add(new Integer[] { row, column });
	}

	public String getBlockPattern() {
		return blockPattern;
	}

	public void setBlockPattern(String blockPattern) {
		this.blockPattern = blockPattern;
	}
	
}
