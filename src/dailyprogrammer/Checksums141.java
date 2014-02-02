package dailyprogrammer;

/**
 * Input Description:
 * On standard console input, you will first be given an integer N which ranges 
 * inclusively from 1 to 256. After this line, you will receive N-lines of ASCII text. 
 * This text will only contain regular printable characters, and will all be on a single line of input.
 * Output Description:
 * For each line of input, print the index (starting from 1) and the 16-bit Fletcher's 
 * checksum as a 4-digit hexadecimal number.
 */

import javax.xml.bind.annotation.adapters.HexBinaryAdapter;

public class Checksums141 {

	public Checksums141() {
		byte[] text = "Sally sells seashells by the seashore.".getBytes();
		int sum1 = 0;
		int sum2 = 0;
		for (byte b : text) {
			sum1 = ((sum1 + b) % 255);
			sum2 = ((sum1 + sum2) % 255);
		}

		StringBuilder sb = new StringBuilder();
		sb.append(Integer.toString((sum2 << 8) | sum1, 16) + "\n");
		System.out.println(sb.toString());
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Checksums141 check = new Checksums141();
	}

}
