package dailyprogrammer;

import java.util.Scanner;

public class RepulsionForce138 {

	public static void main(String[] args) {

		float[] p = { 1, -5.2f, 3.8f, 1, 8.7f, -4.1f }; // Test input; Out =
														// 0.0039
		Scanner scan = new Scanner(System.in);
		for (int riadky = 0; riadky < 4; riadky += 3) {
			String j[] = scan.nextLine().split("\\s");     // nacitanie udajov z konzoly a rozdelenie 
			for (int c = 0; c < 3; c++) {
				p[c + riadky] = Float.parseFloat(j[c]);
			}
		}
		scan.close();
		float deltaX = (p[1] - p[4]);
		float deltaY = (p[2] - p[5]);
		float distance = (float) Math.pow((deltaX * deltaX + deltaY * deltaY),0.5f);
		System.out.println((p[0] * p[3]) / (distance * distance));
	}
}
