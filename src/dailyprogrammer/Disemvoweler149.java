/** Disemvoweler 149
 * Disemvoweling means removing the vowels from text. (For this challenge, the letters a, e, i, o, 
 * and u are considered vowels, and the letter y is not.) The idea is to make text difficult but not 
 * impossible to read, for when somebody posts something so idiotic you want people who are reading 
 * it to get extra frustrated.
 * To make things even harder to read, we'll remove spaces too. For example, this string:
 * two drums and a cymbal fall off a cliff
 * can be disemvoweled to get:
 * twdrmsndcymblfllffclff
 * We also want to keep the vowels we removed around (in their original order), which in this case is:
 * ouaaaaoai
 
 */
package dailyprogrammer;

import java.util.Scanner;

public class Disemvoweler149 {

	public Disemvoweler149() {
		Scanner scan = new Scanner(System.in);
		char[] input = scan.nextLine().toCharArray();
		String disemvoweled  = "";
		String removedvowels = "";
		for (char c : input) {
			if (c == ' ') continue;
			if (c =='a' || c == 'e' || c == 'o'|| c =='i' || c == 'u')
				removedvowels += c;
			else
				disemvoweled += c;
		}
		
		System.out.println(disemvoweled);
		System.out.println(removedvowels);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Disemvoweler149();

	}

}
