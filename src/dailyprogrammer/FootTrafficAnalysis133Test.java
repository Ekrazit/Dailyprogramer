package dailyprogrammer;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FootTrafficAnalysis133Test {

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
	public void testMain() {
		String inputData = "4\n0 0 I 540\n1 0 I 540\n0 0 O 560\n1 0 O 560\n";
		System.setIn(new java.io.ByteArrayInputStream(inputData.getBytes()));
		FootTrafficAnalysis133.main(null);
		assertEquals("Room 0, 20 minute average visit, 2 visitor(s) total\r\n", outContent.toString());

	}
}
