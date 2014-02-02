package dailyprogrammer;
/** Polygon Perimeter
 *  Input will consist of one line on standard console input. This line will contain first an integer N, then a floating-point number R. They will be space-delimited. The integer N is for the number of sides of the Polygon, which is between 3 to 100, inclusive. R will be the circumradius, which ranges from 0.01 to 100.0, inclusive.
 *	Print the permitter of the given N-sided polygon that has a circumradius of R. Print up to three digits precision 
 * 	Sample Input 1 : 5 3.7
 * 	Sample Output 1 : 21.748
 * 	Sample Input 2 : 100 1.0
 * 	Sample Output 2 : 6.282
 */

import java.util.Locale;
import java.util.Scanner;

public class PolygonPerimeter146 {

	public PolygonPerimeter146() {
		Scanner scan = new Scanner(System.in);
		String inputString[] = scan.nextLine().split("\\s");
		double inputInt[] = new double[inputString.length];
		for (int i = 0; i < inputInt.length; i++) {
			inputInt[i] =  Double.parseDouble(inputString[i]);
		}
		double output = 2 * inputInt[0] * inputInt[1] * Math.sin(Math.PI / inputInt[0]);
		System.out.format(Locale.US,"%.3f%n",output);
	
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PolygonPerimeter146 pp146 = new PolygonPerimeter146();

	}

}
