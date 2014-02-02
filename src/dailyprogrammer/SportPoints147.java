package dailyprogrammer;
/**
 * 
 *   6 points for a "touch-down"
 *   3 points for a "field-goal"
 *   1 point for an "extra-point"; can only be rewarded after a touch-down. Mutually-exclusive with "two-point conversion"
 *   2 points for a "two-point conversion"; can only be rewarded after a touch-down. Mutually-exclusive with "extra-point"
 * 
 * 
 */
import java.util.Scanner;

public class SportPoints147 {

	private int points[] = { 1, 2, 3, 6 };
	private String invalidScore = "Invalid Score";
	private String validScore = "Valid Score";

	public SportPoints147() {
		Scanner scan = new Scanner(System.in);
		int score = scan.nextInt();
		String inputString[] = scan.nextLine().split("\\s");
		int inputInt[] = new int[inputString.length];
		for (int i = 0; i < inputInt.length; i++) {
			inputInt[i] = Integer.parseInt(inputString[i]);
		}
		int output = 0;
		System.out.println(output);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SportPoints147 sp147 = new SportPoints147();

	}

}
