package dailyprogrammer;

import java.util.Random;
import java.util.Scanner;

public class RolltheDies130 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String[] input = scan.nextLine().split("d");
		int pocetRolov = Integer.valueOf(input[0]);
		int maxRoll = Integer.valueOf(input[1]);
		Random rnd = new Random();
		for (int x = 0; x < pocetRolov; x++){
				System.out.print(rnd.nextInt(maxRoll)+ " ");
		}

	}

}
