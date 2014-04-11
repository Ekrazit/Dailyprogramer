package dailyprogrammer;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class NutsBolts144Test {
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	
	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));

	}

	@After
	public void cleanUpStreams() {
		System.setOut(null);
	}
	
	@Test
	public void test() {
		String inputData = "4\nCarriageBolt 45\nEyebolt 50\nWasher 120\nRivet 10\nCarriageBolt 45\nEyebolt 45\nWasher 140\nRivet 10\n";
		System.setIn(new java.io.ByteArrayInputStream(inputData.getBytes()));
		NutsBolts144 bt144 = new NutsBolts144();
		assertEquals("Eyebolt -5\nWasher 20\n", outContent.toString());
	}
	
	@Test
	public void test2() {
		String inputData = "3\n2DNail 3\n4DNail 5\n8DNail 10\n8DNail 11\n4DNail 5\n2DNail 2\n";
		System.setIn(new java.io.ByteArrayInputStream(inputData.getBytes()));
		NutsBolts144 bt144 = new NutsBolts144();
		assertEquals("8DNail 1\n2DNail -1\n", outContent.toString());
		
	}

}
