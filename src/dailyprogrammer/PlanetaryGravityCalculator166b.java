/**Planetary Gravity Calculator
 * 
 * You will be given a number M which is the mass of an object in kilograms, on its own line, for example: 100
 * Followed by a number N:4
 * You will then, on separate lines, be given a list of N planets. This will be given as its name, its radius (in metres), 
 * and its average density (in kilograms per cubic metre), like so: Mercury, 2439700, 5427
 * Example Input
100
4
Tantalus, 3104500, 5009
Reach, 7636500, 4966
Circumstance, 4127000, 4132
Tribute, 2818000, 4358

*Example Output

Tantalus: 434.467
Reach: 1059.536
Circumstance: 476.441
Tribute: 343.117

 */

package dailyprogrammer;

import java.util.ArrayList;
import java.util.Scanner;

public class PlanetaryGravityCalculator166b {
	
	private final double G_CONSTANT = 6.67e-11;
	private int boxMass;
	private int pocetPlanet;
	private ArrayList<Planet> planets = new ArrayList<Planet>();

	public PlanetaryGravityCalculator166b() {
		read();
		calculate();
	}


	private void calculate() {
		for(Planet planet: planets){
			double force = G_CONSTANT * boxMass * planet.getMass()/(planet.getPolomer()*planet.getPolomer());
			System.out.printf( planet.getPlanetname() + ": %.3f%n ", force);
		}
		
	}



	private void read() {
		Scanner scan = new Scanner(System.in);
		boxMass =  Integer.valueOf(scan.nextLine().trim());
		pocetPlanet =  Integer.valueOf(scan.nextLine().trim());
		for (int i = 0; i < pocetPlanet; i++) {
			String[] nexline = scan.nextLine().trim().split(",");
			planets.add(new Planet(nexline[0], Long.valueOf(nexline[1].trim()), Long.valueOf(nexline[2].trim())));
			
		}
	}



	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new PlanetaryGravityCalculator166b();
		
/*		Planet pl =  new Planet("Tantalus", 3104500, 5009);
		System.out.println("Hmotnost planety "+ pl.getPlanetname() +" : " +pl.getMass());
		double force = 6.67e-11 * 100 * pl.getMass()/(pl.getPolomer()*pl.getPolomer());
		System.out.println(force);
	*/	
	}

}

final class Planet {
	private String planetname;
	private long hustota;
	private long polomer;

	public String getPlanetname() {
		return planetname;
	}

	public void setPlanetname(String planetname) {
		this.planetname = planetname;
	}

	public long getHustota() {
		return hustota;
	}

	public void setHustota(long hustota) {
		this.hustota = hustota;
	}

	public long getPolomer() {
		return polomer;
	}

	public void setPolomer(long polomer) {
		this.polomer = polomer;
	}

	public Planet(String planetname, long hustota, long polomer) {
		this.planetname = planetname;
		this.hustota = hustota;
		this.polomer = polomer;
	}

	public double getMass() {
		return hustota * (4 * 3.1415 * polomer * polomer * polomer) / 3;
	}

}