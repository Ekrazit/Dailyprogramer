package dailyprogrammer;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class FootTrafficAnalysis133 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int pocetRiadkov = scan.nextInt();
		int roomVisitors[]  = new int[100];
		int roomsAverageTime[]  = new int[100];
		int visitorTime[]  = new int[100];
		for (int x = 0; x < pocetRiadkov; x++){
			int visitor = scan.nextInt();
			int room = scan.nextInt();
			if (scan.next().equals("I")){
				roomVisitors[room]++;
				visitorTime[visitor] = scan.nextInt();
			} else{
				roomsAverageTime[room] = roomsAverageTime[room] +  scan.nextInt() - visitorTime[visitor];
			}
		}
		scan.close();
		for (int x=0; x < 100; x++)
			if (roomVisitors[x] != 0)
				System.out.println("Room "+x+", "+roomsAverageTime[x]/roomVisitors[x]+" minute average visit, "+roomVisitors[x]+" visitor(s) total");
	}

//********************************************************	
    public static void mainOtsojaun(String args[]){ 
        int n = Integer.parseInt(args[0]);
        Map<Integer, int[]> m = new TreeMap<Integer, int[]>();
        for (int i = 0; i < n; i++){
            int room = Integer.parseInt(args[i*4+2]);
            char direction = args[i*4+3].charAt(0);
            int time = Integer.parseInt(args[i*4+4]);
            int[] d = m.get(room);
            if (d == null)
                d = new int[2];
            if (direction == 'I')
                d[0] -= time;
            else
                d[0] += time;
            d[1]++;
            m.put(room, d);
        }

        for (Map.Entry<Integer, int[]> u : m.entrySet()){
            int  v = u.getValue()[1] / 2;
            System.out.println("Room " + u.getKey() + ", " + u.getValue()[0] / v + " minute average visit, " + v + " visitor(s) total");
        }
    }
	
}
