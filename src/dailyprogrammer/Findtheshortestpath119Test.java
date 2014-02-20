package dailyprogrammer;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Findtheshortestpath119Test {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private Findtheshortestpath119 ftstp119 = new Findtheshortestpath119();
	private char matica[][] = {{'S','.','.','.','.'}, 
			                   {'W','W','W','W','.'},
			                   {'.','.','.','.','.'},
			                   {'.','W','W','W','W'},
			                   {'.','.','.','.','E'}};
	
	private char matica2[][] = {{'.','.','.','S'},
						   	    {'.','.','.','.'},
							    {'.','.','.','.'},
							    {'.','.','.','E'}};
	
	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));

	}

	@After
	public void cleanUpStreams() {
		System.setOut(null);
	}
	@Test
	public void testInit() {
		String inputData = "5\nS....\nWWWW.\n.....\n.WWWW\n....E\n";
		System.setIn(new java.io.ByteArrayInputStream(inputData.getBytes()));
		ftstp119.init();
		assertEquals("true, 16\r\n", outContent.toString());
	}
	
	@Test
	public void testInit2() {
		String inputData = "4\n...S\n....\n....\n...E\n";
		System.setIn(new java.io.ByteArrayInputStream(inputData.getBytes()));
		ftstp119.init();
		assertEquals("true, 3\r\n", outContent.toString());
	}
	
	@Test
	public void testInit3() {
		String inputData = "4\nSW.E\n.W..\n.W..\n.W..\n";
		System.setIn(new java.io.ByteArrayInputStream(inputData.getBytes()));
		ftstp119.init();
		assertEquals("false, 3\r\n", outContent.toString());
	}
	
	@Test
	public void testInit4() {
		String inputData = "8\nS...W...\n.WW.W.W.\n.W..W.W.\n......W.\nWWWWWWW.\nE...W...\nWW..WWW.\n........\n";
		System.setIn(new java.io.ByteArrayInputStream(inputData.getBytes()));
		ftstp119.init();
		assertEquals("true, 29\r\n", outContent.toString());
	}
	
	@Test
	public void skontrolujStartEndTest1(){
		
		assertEquals(true, ftstp119.skontrolujStartEnd(matica));
	}

	@Test
	public void najdiSusedovTest1(){
		node pociatocnyBod = new node();
		pociatocnyBod.setX(0);
		pociatocnyBod.setY(0);
		ArrayList<node> outtest = ftstp119.najdiSusedov(matica, pociatocnyBod);
		assertEquals(0, outtest.get(0).getX());
		assertEquals(1, outtest.get(0).getY());
	}
	
	@Test
	public void najdiSusedovTest2(){
		node pociatocnyBod = new node();
		pociatocnyBod.setX(1);
		pociatocnyBod.setY(1);
		ArrayList<node> outtest = ftstp119.najdiSusedov(matica, pociatocnyBod);
		assertEquals(0, outtest.get(0).getX());
		assertEquals(1, outtest.get(0).getY());
		assertEquals(2, outtest.get(1).getX());
		assertEquals(1, outtest.get(1).getY());
	
	}
	
	
}
