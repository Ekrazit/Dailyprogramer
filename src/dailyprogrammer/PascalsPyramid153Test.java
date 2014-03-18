package dailyprogrammer;

import static org.junit.Assert.*;

import org.junit.Test;

public class PascalsPyramid153Test {

	@Test
	public void testCalculateNode() {
		assertEquals(6, PascalsPyramid153.calculateNode(2, 0, 2));
		assertEquals(1, PascalsPyramid153.calculateNode(4, 0, 0));
		assertEquals(30, PascalsPyramid153.calculateNode(1, 2, 2));
	}

	@Test
	public void testFactorial() {
		assertEquals(3628800, PascalsPyramid153.factorial(10));
		assertEquals(87178291200l, PascalsPyramid153.factorial(14));
		assertEquals(1, PascalsPyramid153.factorial(0));
		assertEquals(1, PascalsPyramid153.factorial(1));
		assertEquals(2, PascalsPyramid153.factorial(2));
		
	}

}
