/** Zoom, Rotate, Invert Hex Picture 171
 * 
 *   Zoom - zoom in or out of the image
 *   Rotate - turn the image 90 degrees clockwise or counter clockwise
 *   Invert - What was On is Off and what is Off becomes On. It inverts the image
 * ZOOM
 * 
 * 12
 * 34
 * 
 * If you perform a zoom in x2 you will generate this image.
 * 
 * 1122
 * 1122
 * 3344
 * 3344
 * 
 * ROTATE
 * 
 * 12
 * 34
 * 
 * If you rotate it 90 clockwise:
 * 
 * 31
 * 42
 * 
 * INVERT
 *  ##########
 *  #xxxxxxxx#
 *  #x      x#
 *  #x xxxx x# 
 *  #x x  x x#
 *  #x x  x x#
 *  #x xxxx x#
 *  #x      x#
 *  #xxxxxxxx#
 *  ##########
 *  
 *  The invert of it becomes:
 *  
 *   ##########
 *   #        #
 *   # xxxxxx #
 *   # x    x #
 *   # x xx x #
 *   # x xx x #
 *   # x    x #
 *   # xxxxxx #
 *   #        #
 *   ##########
 */

package dailyprogramer;

public class ZoomRotateInvertHexPicture171 {

	public ZoomRotateInvertHexPicture171() {
	}

	/**
	 * 
	 * @param in
	 * @return
	 */
	public String[][] zoom(String[][] in) {
		String vysledok[][] = new String[in.length * 2][in[0].length * 2];
		for (int row = 0; row < in.length; row++) {
			for (int column = 0; column < in[0].length; column++) {
				vysledok[row*2][column*2] =  in[row][column];
				vysledok[row*2+1][column*2] =  in[row][column];
				vysledok[row*2+1][column*2+1] =  in[row][column];
				vysledok[row*2][column*2+1] =  in[row][column];
			}
		}
		return vysledok;
	}

	/**
	 * Otoci maticu o 90 stupnov
	 * 
	 * @param in vstupna matica
	 * @return otocena matica
	 */

	public String[][] rotate(String[][] in) {
		
		int rowx = 0 ;
		int columnx = in.length - 1;
		String vysledok[][] = new String[in[0].length][in.length];
		for (int row = 0; row < in.length; row++) {
			for (int column = 0; column < in[0].length; column++) {
			 	vysledok[rowx][columnx] = in[row][column];
			 	rowx++;
		  }
			columnx--;
			rowx = 0;
		}
		return vysledok;
	}

	/**
	 * 	invertuje vstupnu maticu
	 * @param in
	 * @return
	 */
	public String[][] invert(String[][] in) {
		String vysledok[][] = new String[in.length][in[0].length];
		for (int row = 0; row < in.length; row++) {
			for (int column = 0; column < in[0].length; column++) {
				if (in[row][column].equals("x"))
					vysledok[row][column] = "#";
				else
					vysledok[row][column] = "x";
			}
		}
		return vysledok;
	}
}
		
