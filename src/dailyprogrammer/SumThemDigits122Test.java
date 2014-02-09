package dailyprogrammer;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SumThemDigits122Test {
	SumThemDigits122 std122 = new SumThemDigits122();
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
	public void testInt() {
		String inputData = "31337\n";
		System.setIn(new java.io.ByteArrayInputStream(inputData.getBytes()));
		std122.init();
		assertEquals("8, because 3+1+3+3+7=17 and 1+7=8 \r\n", outContent.toString());

	}

	@Test
	public void testRozdelCislo1() {
		ArrayList<Integer> test1 = new ArrayList<Integer>();
		test1.add(1);
		test1.add(2);
		test1.add(3);
		test1.add(4);
		test1.add(5);
		test1.add(6);
		assertEquals(test1, std122.rozdelCislo(123456));
	}
	
	@Test
	public void spocitajListTest1() {
		ArrayList<Integer> test1 = new ArrayList<Integer>();
		test1.add(1);
		test1.add(2);
		test1.add(3);
		test1.add(4);
		test1.add(5);
		test1.add(6);
		assertEquals(21, std122.spocitajList(test1));
		
	}
	
	@Test
	public void spocitanieCiselTest(){
		String a =  std122.spocitanieCisel(1234);
		assertEquals("1+2+3+4=10 ", a);
	}

}
