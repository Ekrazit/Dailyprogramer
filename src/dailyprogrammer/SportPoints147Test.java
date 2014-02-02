package dailyprogrammer;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SportPoints147Test {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private SportPoints147 sp1;

	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));

	}

	@After
	public void cleanUpStreams() {
		System.setOut(null);
	}

	@Test
	public void testSportPoints147() {

		String inputData = "35";
		System.setIn(new java.io.ByteArrayInputStream(inputData.getBytes()));
		sp1 = new SportPoints147();
		assertEquals("Valid Score\r\n", outContent.toString());
		inputData = "2";
		System.setIn(new java.io.ByteArrayInputStream(inputData.getBytes()));
		sp1 = new SportPoints147();
		assertEquals("Invalid Score\r\n", outContent.toString());
	}

}
