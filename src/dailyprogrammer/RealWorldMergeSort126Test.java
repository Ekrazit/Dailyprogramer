package dailyprogrammer;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RealWorldMergeSort126Test {
	private RealWorldMergeSort126 rwms126 = new RealWorldMergeSort126();
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
		String inputData = "692 1 32\n0 0 0 14 15 123 2431\n";
		System.setIn(new java.io.ByteArrayInputStream(inputData.getBytes()));
		RealWorldMergeSort126 rw126 = new RealWorldMergeSort126();
		rw126.init();
		assertEquals("1 14 15 32 123 692 2431 ", outContent.toString());
	}

	@Test
	public void testMergesort1() {
		int[] input = {6, 5, 4 ,3, 2, 1 };
		int[] output = {1, 2, 3 ,4, 5, 6 };
		assertArrayEquals(output, rwms126.mergesort(input));
	}

}
