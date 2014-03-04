package dailyprogrammer;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

/** N-Dimensional Vectors
 * N-Dimensional vectors are vectors with n-components; it can be interpreted as a point in 
 * n-dimensional space. 2-dimensional (2D) vectors can be seen as a line on paper. 3D vectors 
 * can be seen as a line (direction with length) in regular space. You can represent higher 
 * n-dimensions in many different ways, but what we're interested in is the three common vector 
 * operations: length, normilization, and dot-product.You are to implement code that first 
 * accepts a few vectors, the operations you want to perform on them, and their results.
 * 
 * Input Description
 * You will be given an integer N on standard input, which represents the N-following number 
 * of lines of text. The start of each line will be a positive non-zero integer A, where A is 
 * the following number of space-delimited Real number (floating-point in many languages). 
 * These numbers representing a vector of A-dimensions (or an A-component vector). After these 
 * N-lines of text, expect a single line with an integer M, which represents the M-following 
 * number of lines of text. Each line will start with the characters 'l', 'n', or 'd', 
 * representing the function you are to compute. After that, you can expect one or two 
 * space-delimited integers. These integers represent the index of the above-defined vectors; 
 * the indexing scheme starts at zero (0). An 'l' and 'n' line will be given a single integer, 
 * while a 'd' will be given two space-delimited integers.
 * 
 * Output Description
 * For each line that defines the function ('l' for length, 'n' for normalize, and 'd' for 
 * dot-product) and operands (the vector values based on the given indices), you are to print 
 * the result of the appropriate computation on standard console output. The length-function 
 * must compute the given vector's Euclidean space length. The normalize-function must compute 
 * the given vector's Unit vector. Finally, the Dot-product function must compute the two given 
 * vector's, well... Dot Product! When printing your result, you may choose however you print 
 * the result (regular float, or scientific notation), but you must be accurate with 5 decimals.
 * Sample Inputs & Outputs
 * Sample Input
 * 5
 * 2 1 1
 * 2 1.2 3.4
 * 3 6.78269 6.72 6.76312
 * 4 0 1 0 1
 * 7 84.82 121.00 467.05 142.14 592.55 971.79 795.33
 * 7
 * l 0
 * l 3
 * l 4
 * n 1
 * n 2
 * n 3
 * d 0 1
 * Sample Output
 * 1.4142
 * 1.4142
 * 1479.26
 * 0.33282 0.94299
 * 0.579689 0.574332 0.578017
 * 0 0.707107 0 0.707107
 * 4.6
 * 
 */

public class NDimensionalVectors129 {
	private Scanner scan = new Scanner(System.in);

	public NDimensionalVectors129() {
		// TODO Auto-generated constructor stub
	}
	protected void init(){
		ArrayList<vektory> vekList = nacitaj();
		String out = vyhodnot(vekList);
		System.out.println(out);
		
	}
	
	private ArrayList<vektory> nacitaj(){
		ArrayList<vektory> vekList = new ArrayList<vektory>();
		int pocetVektorov = Integer.valueOf(scan.nextLine().trim());
		for (int i = 0; i < pocetVektorov; i++) {
			String temp[] = scan.nextLine().split("\\s");
			vektory vek = new vektory();
			int nVektor = Integer.valueOf(temp[0]);
			for (int j= 1; j <= nVektor; j++) {
				vek.addToVektory(Float.valueOf(temp[j]));
			}
			vekList.add(vek);
		}
		return vekList;
	}

	 protected String vyhodnot(ArrayList<vektory> vekList) {
		int pocetUkonov = Integer.valueOf(scan.nextLine().trim());
		String out = "";
		for (int i = 0; i < pocetUkonov; i++) {
			String temp[] = scan.nextLine().split("\\s");
			int indexVekturu = Integer.parseInt(temp[1]);
			switch (temp[0]) {
			case "l":
				out += dlzka(vekList.get(indexVekturu));
				break;
			case "n":
				out +=normallize(vekList.get(indexVekturu));
				break;
			case "d":
				int indexVekturu2 = Integer.parseInt(temp[2]);
				out +=dotProdukt(vekList.get(indexVekturu),
						vekList.get(indexVekturu2));
				break;

			default:
				break;
			}
			
		}
		return out;
	}
	
	protected String dlzka(vektory vek){
		float in = 0;
		for (float i : vek.getnVektory()) {
			in += i* i;
		}
		in = (float) Math.sqrt(in);
		
		return String.format(Locale.US,"%.3f%n", in);
	}
	
	protected String normallize(vektory vek){
		String out = "";
		float in = 0;
		for (float i : vek.getnVektory()) {
			in += i* i;
		}
		in = (float) Math.sqrt(in);
		for (float i : vek.getnVektory()) {
		   out += String.format(Locale.US,"%.3f ", i/in); 
		}
		return out + "\n";
		
	}
	
	protected String dotProdukt(vektory vek1,vektory vek2){
		int max = Math.min(vek1.getnVektory().size(), vek2.getnVektory().size());
		float out = 0;
		for (int i = 0; i < max; i++) {
			out += vek1.getnVektory().get(i) * vek2.getnVektory().get(i); 
		}
		
		return String.format(Locale.US,"%.3f%n", out);
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	NDimensionalVectors129 ndv129 =  new NDimensionalVectors129();
	ndv129.init();

	}

}

class vektory {
	private ArrayList<Float> nVektory = new ArrayList<Float>();

	/**
	 * @return the nVektory
	 */
	protected ArrayList<Float> getnVektory() {
		return nVektory;
	}
	
	protected void addToVektory(float bod){
		this.nVektory.add(bod);
	}

	/**
	 * @param nVektory the nVektory to set
	 */
	protected void setnVektory(ArrayList<Float> nVektory) {
		this.nVektory = nVektory;
	}
	
}