package dailyprogrammer;

import java.io.IOException;

public class Divisibledigits {

	public Divisibledigits() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x1 = 7;
		int x2 = 4241275;
		

		int out = (int) Math.pow(10, x1) - 1;

		while (out % x2 != 0){
			out--;
		}
			
		
		System.out.println(out);
		
		
	}

}
