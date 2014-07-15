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



package dailyprogramer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BlockCountLengthArea168 {

	private String[][] matrix;
	private ArrayList<Block> blocks = new ArrayList<Block>();
	private Set<String> blockPattern = new HashSet<String>();

	public static void main(String[] args) {
		new BlockCountLengthArea168().init();
	}

	public BlockCountLengthArea168() {
	}

	protected void init() {
		read();
		calculate();
		printresults();
	}

	/**
	 * vypis hodnot
	 * 
	 */

	protected void printresults() {

		for (String pattern : blockPattern) {
			int obvod = 0;
			int obsah = 0;
			int pocetblokov = 0;
			for (Block block : blocks) {
				if (block.getBlockPattern().equals(pattern)) {
					obvod += block.getObvod();
					obsah += block.getPlocha();
					pocetblokov++;
				}
			}
			System.out.println(pattern + ": Total SF (" + obsah+ "), Total Circumference LF (" + obvod + ") - Found "
					+ pocetblokov + " block");
		}
	}

	/**
	 * Hlavna kalkulacia , skontroluje ci neni bunka uz v bloku a potom progresivne hlada vsetky buky do bloku 
	 */
	protected void calculate() {
		for (int row = 0; row < this.matrix[0].length; row++) {
			for (int column = 0; column < this.matrix.length; column++){
				if (!checkCell(row, column)) {	
					Block aktualnyblok = pridajdonovehobloku(this.matrix, row, column, this.matrix[row][column]);
					blockPattern.add(this.matrix[row][column]);
					HashSet<Integer[]> susendebloku = najdiSusedne(row, column, this.matrix[row][column], aktualnyblok);
					while (susendebloku.size() > 0) {
						HashSet<Integer[]> docasny = new HashSet<Integer[]>();
						for (Integer[] pozicia : susendebloku) {
								if (!checkCell(pozicia[0], pozicia[1]))
										aktualnyblok.addblock(pozicia[0], pozicia[1]);
								docasny.addAll(najdiSusedne(pozicia[0], pozicia[1],	this.matrix[row][column],aktualnyblok));
						}
						susendebloku.clear();
						susendebloku = docasny;
					}
				}

			}
		}

	}

	/**
	 * najde sussedne bloky , tak aby skontroloval si uz sa nenachadza nieco v aktualnom bloku
	 * 
	 * @param matrix2 matica na ktorej sa to bude testovat
	 * @param row 
	 * @param column
	 * @param aktualnyblok 
	 * @param string textura na "fotografii"
	 * @return zoznam vsetkych susednych objektov 
	 */
	protected HashSet<Integer[]> najdiSusedne(int row, int column, String textura, Block aktualnyblok) {
		HashSet<Integer[]> najdenecell =  new HashSet<Integer[]>();
		if (isPartofMatrix(row-1,column))
			if (this.matrix[row -1][column].equals(textura) && !aktualnyblok.isPart(row-1, column))
				najdenecell.add(new Integer[] {row-1, column});
		if (isPartofMatrix(row+1,column))
			if (this.matrix[row+1][column].equals(textura) && !aktualnyblok.isPart(row+1, column))
				najdenecell.add(new Integer[] {row+1, column});
		if (isPartofMatrix(row,column-1))
			if (this.matrix[row][column-1].equals(textura) && !aktualnyblok.isPart(row, column-1))
				najdenecell.add(new Integer[] {row, column-1});
		if (isPartofMatrix(row,column+1))
			if (this.matrix[row][column+1].equals(textura) && !aktualnyblok.isPart(row, column+1))
				najdenecell.add(new Integer[] {row, column+1});
		return najdenecell;
	}

	/**
	 * @return vyhnutie sa out of bonds error array
	 */
	protected boolean isPartofMatrix(int row, int column) {
		if (row <= -1 || column <= -1) return false;
		if (row >= this.matrix.length || column >= this.matrix.length) return false;
		return true;
	}

	/**
	 * zalozi noviblok s hodnotou texturov
	 * 
	 * @param matrix2  matica na ktorej sa to bude testovat
	 * @param row riadok
	 * @param column stlpec
	 * @return vrati novovytvoreny blok
	 */
	protected Block pridajdonovehobloku(String[][] matrix2, int row, int column, String textura) {
		ArrayList<Integer[]> cell = new ArrayList<Integer[]>();
		cell.add(new Integer[] {row,column});
		Block blk = new Block(textura, cell);
		this.blocks.add(blk);
		return blk;

	}

	/**
	 * Skontrouje ci na nachadza dana bunka v niektorom z blokov matice
	 * 
	 * @param row riadok 
	 * @param column stlpec
	 * @return vrati ci je uz dana bunka v nejakom bloku 
	 */
	protected boolean checkCell(int row, int column) {
			 for (Block checkblock : this.blocks) {
				if (checkblock.isPart(row, column)) return true;
			}
		return false;
	}

	/**
	 * nacitanie hodnout z prikazoveho riadka. Predpoklada sa stvorcova matica
	 */
	protected void read() {
		Scanner scan = new Scanner(System.in);
		int riadok = 0;
		while (scan.hasNextLine()) {
			String[] nexline = scan.nextLine().split("(?!^)");
			if (nexline.length <= 1)
				break;
			if (matrix == null)
				matrix = new String[nexline.length][nexline.length];
			matrix[riadok] = nexline;
			riadok++;
		}
	}
}

/**
 * Drzi v obejekte hodnoty jednotlivych blokov a vypocitava pozadovane udaje
 * 
 * @author RG
 * 
 */

class Block {

	private String blockPattern;

	ArrayList<Integer[]> bloky = new ArrayList<Integer[]>();

	Block(String blockPattern) {
		this.setBlockPattern(blockPattern);
	}

	Block(String blockPattern, ArrayList<Integer[]> bloky) {
		this.setBlockPattern(blockPattern);
		this.bloky = bloky;
	}

	/**
	 * Vrati plochu drzanu v tomto objekte
	 * 
	 * @return Area of block
	 */
	public int getPlocha() {
		return bloky.size() * 100;
	}

	/**
	 * vrati obvod drzany v tomto objekte
	 * 
	 * @return circumviation of block
	 */
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

	/**
	 * skontroluje ci bunka sucastov objektu.
	 * 
	 * @param row
	 * 
	 * @param column
	 * 
	 * @return is part of object
	 */
	public boolean isPart(int row, int column) {
		for (Integer[] c : bloky) {
			if (c[0].intValue() == row && c[1].intValue() == column)
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
