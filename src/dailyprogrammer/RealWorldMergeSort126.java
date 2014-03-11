package dailyprogrammer;

import java.util.Arrays;
import java.util.Scanner;

public class RealWorldMergeSort126 {
	private int[] originalArray;
	private int[] sortedArray;

	public RealWorldMergeSort126() {
		// TODO Auto-generated constructor stub
	}
	protected void init(){
		Scanner scan = new Scanner(System.in);
		String textline = scan.nextLine();
		textline += scan.nextLine();
		String textemp[] = textline.split("\\s+");
		int[] tempint = new int[textemp.length];
		for (int i = 0; i < textemp.length; i++) {
			tempint[i] = Integer.parseInt(textemp[i]);
		}
		tempint = mergesort(tempint);
		for (int i = 0; i < tempint.length; i++) {
			System.out.print(tempint[i]+ " ");
		}
		
	}

	protected int[] mergesort(int[] vstup) {
		this.originalArray = vstup;
		this.sortedArray = new int[vstup.length];
		vydel(0, vstup.length - 1);
		return originalArray;
	}

	// http://www.apekshit.com/t/44/Merge-Sort
	private void vydel(int low, int high) {
		if (low < high) {
			int middle = (low + high) / 2;
			vydel(low, middle);
			vydel(middle + 1, high);
			skommbine(low, middle, high);
		}
	}

	private void skommbine(int low, int middle, int high) {
		for (int i = low; i <= high; i++) {
			sortedArray[i] = originalArray[i];
		}
	
		int i = low;
		int j = middle + 1;
		int k = low;
		while (i <= middle && j <= high) {
			if (sortedArray[i] <= sortedArray[j]) {
				originalArray[k] = sortedArray[i];
				i++;
			} else {
				originalArray[k] = sortedArray[j];
				j++;
			}
			k++;
		}
		while (i <= middle) {
			originalArray[k] = sortedArray[i];
			k++;
			i++;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
