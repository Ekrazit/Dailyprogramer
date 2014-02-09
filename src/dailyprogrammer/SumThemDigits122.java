package dailyprogrammer;
/** Sum Them Digits 122
 * As a crude form of hashing function, Lars wants to sum the digits of a number. 
 * Then he wants to sum the digits of the result, and repeat until he have only one
 * digit left. He learnt that this is called the digital root of a number, but the
 * Wikipedia article is just confusing him.
 * 
 * Sample Input:
 * 31337
 * Sample Output:
 * 8, because 3+1+3+3+7=17 and 1+7=8
 */


import java.util.ArrayList;
import java.util.Scanner;

public class SumThemDigits122 {

	public SumThemDigits122() {
		// TODO Auto-generated constructor stub
	}

	protected void init(){
		Scanner scan = new Scanner(System.in);
		int vstup = scan.nextInt();		// len Integer.MAX velkost cisla!
		String output = "";
		
		if (vstup > 10) {
			output =  spocitanieCisel(vstup);
			output = output.substring(output.length()-2,output.length()).trim() + ", because "+ output;
		}else {
			output = String.valueOf(vstup);
		}
		
		System.out.println(output);
	}
	
	protected String spocitanieCisel(int vstup){
		ArrayList<Integer> temparray = new ArrayList<Integer>();
		String tempOutput = "";
		while (vstup > 10){
			temparray = rozdelCislo(vstup);
			vstup = spocitajList(temparray);
			for (Integer integer : temparray) {
				tempOutput = tempOutput + integer + "+"; 
			}
			tempOutput = tempOutput.substring(0, tempOutput.length()-1);
			tempOutput += "=" + vstup + " and ";
		}
		tempOutput = tempOutput.substring(0, tempOutput.length()-4);
		return tempOutput;
	}
	

	protected ArrayList<Integer> rozdelCislo(int cislo){
		ArrayList<Integer> temparray = new ArrayList<Integer>();
		while (cislo > 0){
			temparray.add(0, cislo % 10);
			cislo = cislo / 10;
		}
		return temparray;
	}
	
	
	protected int spocitajList(ArrayList<Integer> listNaSpocitanie){
		int sucet = 0;
		for (Integer integer : listNaSpocitanie) sucet += integer;
		return sucet;
	}
	
	public static void main(String[] args) {
		SumThemDigits122 std122 = new SumThemDigits122();
		std122.init();
	}

}
