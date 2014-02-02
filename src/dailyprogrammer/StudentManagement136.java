package dailyprogrammer;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class StudentManagement136 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int pocetStudentov;
		int pocetZnamok;
		
		ArrayList<String> Studenti = new ArrayList<String>();
		ArrayList<Float> znamky = new ArrayList<Float>();
		
		
		Scanner scan = new Scanner(System.in);
		String firstLine[] =  scan.nextLine().split("\\s");

		pocetStudentov = Integer.parseInt(firstLine[0]);
		pocetZnamok = Integer.parseInt(firstLine[1]);
		
		for ( int i = 0; i < pocetStudentov; i++){ 		// na firstline[0] = pocet studentov 
			String in[] =  scan.nextLine().split("\\s");
			Studenti.add(in[0]);
			for (int x = 0; x < pocetZnamok; x++){
				znamky.add((float) Integer.parseInt(in[x+1]));
				
			}
		}
		
		float priemer = 0;
		for (Float c: znamky) priemer += c;
		priemer = priemer / znamky.size();
		System.out.format(Locale.US,"%.2f%n",priemer);

		for (int x = 0; x < pocetStudentov; x++){
			float priemerStudenta = 0;
			for (int i= 0; i <pocetZnamok; i++){
				priemerStudenta += znamky.get(i + (x*pocetZnamok)); 
			}
			priemerStudenta = priemerStudenta / pocetZnamok;
			System.out.format(Locale.US,"%s %.2f%n",Studenti.get(x), priemerStudenta);
		}
	}
	


}
