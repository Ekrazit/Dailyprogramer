package dailyprogrammer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class CoinDenomination134 {
	static boolean endofMap = false;
	static int cilovaHodnota = 200; 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
///		Scanner scan = new Scanner(System.in);
//		String[] ss  = scan.nextLine().split("\\s");
		int pocetRiadkov = 1; // Integer.parseInt(ss[0]);
//		 Integer.parseInt(ss[1]);
		
		for (int i = 0 ; i < pocetRiadkov; i++){

//			String[] nacitanyRiadok = scan.nextLine().split("\\s");
			int[] hodnotyMinci = {1,2 ,5,10};// new int[nacitanyRiadok.length];
///			for (int j = 0; j < nacitanyRiadok.length; j++) hodnotyMinci[j] = Integer.parseInt(nacitanyRiadok[j]);

			HashMap<Integer, Integer> mincovna = new HashMap<Integer, Integer>();
			for (int k : hodnotyMinci) mincovna.put(k, 0); 
				
				while (!endofMap){
					mincovna = prihodKMape(mincovna, hodnotyMinci);
					if ( sucetMapi(mincovna, hodnotyMinci) == cilovaHodnota) {
						for(Map.Entry<Integer, Integer> entry : mincovna.entrySet()) {
							if (entry.getValue() !=0 )	System.out.print(entry.getKey() + "="+entry.getValue() + " ");
						}
						System.out.println(" ");
					}
				}
		}
	}
	
	private static int sucetMapi(HashMap<Integer, Integer> mincovna, int[] kluce){
		int sucet = 0;
		for (int i =0; i < mincovna.size(); i++) {
			sucet = sucet + mincovna.get(kluce[i]) * kluce[i];
		}
		return sucet;
	}
	
	private static HashMap<Integer, Integer> prihodKMape (HashMap<Integer, Integer> mapakprihodeniu, int[] kluce){
		for (int i = 0; i < mapakprihodeniu.size(); i++) {
			mapakprihodeniu.put(kluce[i],  mapakprihodeniu.get(kluce[i]) + 1);
			if ((mapakprihodeniu.get(kluce[i]) * kluce[i]-1) < cilovaHodnota) break; else {
				if (mapakprihodeniu.size()-1 == i) endofMap = true;
				mapakprihodeniu.put(kluce[i],  0); 
			}
		}
	return mapakprihodeniu;
	}

}
