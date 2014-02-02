package dailyprogrammer;
/*** Combination Lock
 * 
 * 
 * Sample Input : 5 1 2 3
 * Sample Output : 21
 *  
 * Spin lock 2 times clockwise: +10, at position 0
 * Spin lock to first number clockwise: +1, at position 1
 * Spin lock 1 time counter-clockwise: +5, at position 1
 * Spin lock to second number counter-clockwise: +4, at position 2
 * Spin lock to third number clockwise: +1, at position 3
 * 
 */

import java.util.Scanner;

public class CombinationLock148 {

	public CombinationLock148() {
		Scanner scan = new Scanner(System.in);
		String inputScan[] = scan.nextLine().split("\\s");
		int inputInt[] = new int [inputScan.length];
		for (int i = 0; i < inputScan.length; i++) {
			inputInt[i] = Integer.parseInt(inputScan[i]);
		}
		int output = 2* inputInt[0] + inputInt[1]+ inputInt[0];
		output += conterCounterClockWise(inputInt[0],inputInt[1],inputInt[2]);
		for (int i = 2; i < inputInt.length-1; i++) {
			output += counterClockWise(inputInt[0],inputInt[i],inputInt[i+1]);
		}
		System.out.println(output);
	}

	protected int conterCounterClockWise(int maxClock, int startclock, int endClock){
		return startclock < endClock ?  maxClock + startclock - endClock : startclock - endClock;
	}
	
	protected int counterClockWise(int maxClock, int startclock, int endClock){
		return startclock < endClock ?  endClock - startclock : maxClock + endClock - startclock;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CombinationLock148 cb148 = new CombinationLock148();
	}

}
