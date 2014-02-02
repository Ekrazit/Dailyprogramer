package dailyprogrammer;

import java.util.Random;
import java.util.Scanner;

public class MontyHallSimulation141 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MontyHallSimulation141 mhs = new MontyHallSimulation141();
	}

	public MontyHallSimulation141() {
		// Scanner scan = new Scanner(System.in);
		int pocetTestov = 10000;// scan.nextInt();
		Random rnd = new Random();
		int uspenost = 0;

		for (int i = 0; i < pocetTestov; i++) {

			int vybrata = rnd.nextInt(3);
			int cena = rnd.nextInt(3);
			int odokryta = rnd.nextInt(3);
			while (odokryta == cena || odokryta == vybrata) {
				odokryta = rnd.nextInt(3);
			}
			int tempvybrata = vybrata;
			while (tempvybrata == vybrata || odokryta == vybrata) {
				vybrata = rnd.nextInt(3);
			}

			if (vybrata == cena)
				uspenost++;

		}

		System.out.println(pocetTestov + " / " + uspenost);

	}

	private boolean montyhalltest(int vybrata, int cena) {

		return false;
	}
}
