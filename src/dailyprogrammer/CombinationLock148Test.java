package dailyprogrammer;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CombinationLock148Test {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private CombinationLock148 cb1;

	
	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
		String inputData = "5 1 2 3";
		System.setIn(new java.io.ByteArrayInputStream(inputData.getBytes()));
		cb1 = new CombinationLock148();
	}

	@After
	public void cleanUpStreams() {
		System.setOut(null);
	}
	@Test
	public void testmain() {
		assertEquals("21\r\n", outContent.toString());
	}
	
	@Test
	public void testconterCounterClockWise() {
		assertTrue(cb1.conterCounterClockWise(5, 2,4 ) == 3);
		assertTrue(cb1.conterCounterClockWise(5, 3,4 ) == 4);
		assertTrue(cb1.conterCounterClockWise(5, 4,3 ) == 1);
	}
	@Test
	public void testconterClockWise() {
		assertTrue(cb1.counterClockWise(5, 1, 3) == 2);
		assertTrue(cb1.counterClockWise(5, 2, 1) == 4);
		
	}

}
