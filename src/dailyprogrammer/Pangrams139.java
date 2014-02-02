package dailyprogrammer;

import java.util.HashMap;
import java.util.Scanner;

public class Pangrams139 {
 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		char[] alphabetic = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		int r = scan.nextInt(); scan.nextLine();
		for ( int x=0; x < r; x++){
			HashMap<Character, Integer> mapalpha = new HashMap<>(); 
			
			for (char s : scan.nextLine().toLowerCase().replaceAll("[^a-z]", "").toCharArray()){	
				if (mapalpha.containsKey(s)){
					mapalpha.put(s, mapalpha.get(s)+1);
				}else{
					mapalpha.put(s,1);
				}
				
			}
			if (mapalpha.size() == 26){
				System.out.print("true -> ");
			}else{
				System.out.print("false -> ");
			}
			for (char s : alphabetic){
				if (mapalpha.get(s) != null)
				System.out.print(s + ": "+ mapalpha.get(s) + " "); else
					System.out.print(s + ": 0 ");
			}
			System.out.println("");
		}

	}	

}
