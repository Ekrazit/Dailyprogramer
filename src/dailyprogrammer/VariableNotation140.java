package dailyprogrammer;

import java.util.Scanner;

public class VariableNotation140 {

	private Scanner scan;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VariableNotation140 vn = new VariableNotation140();

	}

	public VariableNotation140() {

		scan = new Scanner(System.in);
		int typ = scan.nextInt();
		scan.nextLine();
		String[] textVLine = scan.nextLine().split("\\s+");

		switch (typ) {
		case 0:
			camelCase(textVLine);
			break;
		case 1:
			smakeCase(textVLine);
			break;
		case 2:
			capitalizeSnakeCase(textVLine);
			break;
		default:
			break;
		}
	}

	private void camelCase(String[] text) {
		for (String string : text) {
			String string1 = string.substring(0, 1).toUpperCase();
			String string2 = string.toLowerCase().substring(1);
			System.out.print(string1 + string2);
		}
	}

	private void smakeCase(String[] text) {
		for (String string : text) {
			if (text[text.length - 1].equals(string))
				System.out.print(string);
			else
				System.out.print(string + "_");
		}

	}

	private void capitalizeSnakeCase(String[] text) {
		for (String string : text) {
			if (text[text.length - 1].equals(string))
				System.out.print(string.toUpperCase());
			else
				System.out.println(string.toUpperCase() + "_");
		}
	}
}
