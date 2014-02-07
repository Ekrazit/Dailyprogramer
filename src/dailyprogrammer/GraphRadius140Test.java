package dailyprogrammer;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GraphRadius140Test {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private ArrayList<Integer> conIn =  new ArrayList<Integer>();
	private ArrayList<Integer> conOut =  new ArrayList<Integer>();
	private int matica[][] ={ 
			 {0,1,0,0,1,0}, 
			 {1,0,1,0,1,0},
            {0,1,0,1,0,0},
            {0,0,1,0,1,1},
            {1,1,0,1,0,0},
            {0,0,0,1,0,0}
            };
	
	
	private int matica2[][] ={ 
			 {0,0,0,1}, 
			 {0,0,0,1},
			 {0,0,0,1},
			 {1,1,1,0},
         };
	
	private int matica3[][] ={ 
			 {0,1,1,1}, 
			 {1,0,1,1},
			 {1,1,0,1},
			 {1,1,1,0},
        };
	
	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));

	}

	@After
	public void cleanUpStreams() {
		System.setOut(null);
	}

	@Test
	public void inittest1() {
		String inputData = "10\n0 1 0 0 1 1 0 0 0 0\n1 0 1 0 0 0 1 0 0 0\n0 1 0 1 0 0 0 1 0 0\n0 0 1 0 1 0 0 0 1 0\n1 0 0 1 0 0 0 0 0 1\n1 0 0 0 0 0 0 1 1 0\n0 1 0 0 0 0 0 0 1 1\n0 0 1 0 0 1 0 0 0 1\n0 0 0 1 0 1 1 0 0 0\n0 0 0 0 1 0 1 1 0 0\n";
		System.setIn(new java.io.ByteArrayInputStream(inputData.getBytes()));
		GraphRadius140 gr140 = new GraphRadius140();
		gr140.init();
		assertEquals("2\r\n", outContent.toString());
	
	}

	@Test
	public void vyhodnotenietest1() {
		GraphRadius140 gr140 = new GraphRadius140();
		assertEquals(2,gr140.vyhodnotenie(6, matica));
	}

	@Test
	public void vyhodnotenietest2() {
		GraphRadius140 gr140 = new GraphRadius140();
		assertEquals(1,gr140.vyhodnotenie(4, matica2));
	}
	@Test
	public void vyhodnotenietest3() {
		GraphRadius140 gr140 = new GraphRadius140();
		assertEquals(0,gr140.vyhodnotenie(4, matica3));
	}

	
	@Test
	public void conectedNodestest1() {
		conIn.add(0);
		conOut.add(1);
		conOut.add(4);
		GraphRadius140 gr140 = new GraphRadius140();
		assertEquals(conOut,gr140.conectedNodes(matica, conIn) );
		
	}
	
	@Test
	public void conectedNodestest2() {
		conIn.add(1);
		conIn.add(4);
		conOut.add(0);
		conOut.add(2);
		conOut.add(4);
		conOut.add(0);
		conOut.add(1);
		conOut.add(3);
		GraphRadius140 gr140 = new GraphRadius140();
		assertEquals(conOut,gr140.conectedNodes(matica, conIn) );
		
	}
	
	@Test
	public void chceckFinalNodetest1() {
		conIn.add(0);
		GraphRadius140 gr140 = new GraphRadius140();
		assertEquals(true, gr140.chceckFinalNode(4, matica, conIn));
	}
	
	@Test
	public void chceckFinalNodetest2() {
		conIn.add(2);
		GraphRadius140 gr140 = new GraphRadius140();
		assertEquals(false, gr140.chceckFinalNode(5, matica, conIn));
	}
	
}
