/** Hex to 8x8 Bitmap 
 * You will be given 8 hex values that can be 0-255 in decimal value (so 1 byte).
 *  Each value represents a row. So 8 rows of 8 bits so a 8x8 bitmap picture.
 * 
 * input:
 * 18 3C 7E 7E 18 18 18 18
 * 
 */

package dailyprogramer;

import java.util.Scanner;

public class Hexto8x8Bitmap171 {

	public Hexto8x8Bitmap171() {
	}
	
	private void init(){
		Scanner scan =  new Scanner(System.in);
		String[] instrukcie = scan.nextLine().split("\\s+");
		for (String string : instrukcie) {
			String tlac = 	Integer.toBinaryString(Integer.decode("0x"+string));   // fail!!! missing leading 0
			for (char c : tlac.toCharArray()) {
				if (c ==  '0') {
					System.out.print(" ");
				}else{
					System.out.print("#");

				}
			}
			System.out.println(" ");
		}
	}



	public static void main(String[] args) {
		new Hexto8x8Bitmap171().init();		

	}

}
