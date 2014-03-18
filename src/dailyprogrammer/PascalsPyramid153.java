/** Pascal's Pyramid 1553
 * Sample Input"
 * 5
 * Sample Output:
 * 1
 * 5 5
 * 10 20 10
 * 10 30 30 10
 * 5 20 30 20 5
 * 1 5 10 10 5 1
 */

package dailyprogrammer;

import java.util.Scanner;

public class PascalsPyramid153 {

	public PascalsPyramid153() {
		int heightofpyramide = new Scanner(System.in).nextInt();
		int step = 0;
		for (int height = heightofpyramide; height >= 0; height--) {
			int end = 0;  
			for (int begin = step; begin >= 0 ; begin--){
				System.out.print(calculateNode(height, begin, end) + " ");
				++end;
			}
			System.out.println("");
			step++;
		}
	}
	
	public static long calculateNode(int vyska, int zaciatok , int koniec){
		long menovatel =  factorial(vyska + zaciatok + koniec); 
		long citatel =  factorial(zaciatok) * factorial(vyska) * factorial(koniec);
		return  menovatel / citatel;
	}
	
    public static long factorial(int n) {
        long fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

	public static void main(String[] args) {
		new PascalsPyramid153();

	}

}
