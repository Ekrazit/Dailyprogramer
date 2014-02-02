package dailyprogrammer;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RepulsionForce138Test {

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
		String inputData = "1 -5.2 3.8 \n1 8.7 -4.1";
		System.setIn(new java.io.ByteArrayInputStream(inputData.getBytes()));
		RepulsionForce138.main(null);
		assertEquals("0.0039120573\r\n", outContent.toString());

	}

}
