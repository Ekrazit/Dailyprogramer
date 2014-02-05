package dailyprogrammer;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AdjacencyMatrix140Test {
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
	public void testInit() {
		String inputData = "5 5\n0 -> 1\n1 -> 2\n2 -> 4\n3 -> 4\n0 -> 3\n";
		System.setIn(new java.io.ByteArrayInputStream(inputData.getBytes()));
		AdjacencyMatrix140 aj140 = new AdjacencyMatrix140();
		aj140.init();
		assertEquals("01010\r\n00100\r\n00001\r\n00001\r\n00000\r\n", outContent.toString());
	}

}
