package dailyprogrammer;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StudentManagement136Test {
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
		String inputData = "3 5\nJON 19 14 15 15 16\nJEREMY 15 11 10 15 16\nJESSE 19 17 20 19 18";
		System.setIn(new java.io.ByteArrayInputStream(inputData.getBytes()));
		StudentManagement136.main(null);
		assertEquals("15.93\r\nJON 15.80\r\nJEREMY 13.40\r\nJESSE 18.60\r\n", outContent.toString());

	}
}
