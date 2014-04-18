package dailyprogrammer;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TheWinningMoveXGamesedition157Test {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	TheWinningMoveXGamesedition157 twmxg154 = new TheWinningMoveXGamesedition157();

	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
	}

	@After
	public void cleanUpStreams() {
		System.setOut(null);
	}
	
	private String matrix1[][] ={
			{"X","X","-"},
			{"-","X","O"},
			{"O","O","-"}
	};
	
	private String matrix2[][] ={
			{"O","-","X"},
			{"-","O","X"},
			{"-","-","-"}
	};
	
	private String matrix3[][] ={
			{"-","-","O"},
			{"O","X","X"},
			{"-","-","-"}
	};
	
	private String matrix4[][] ={
			{"-","-","X"},
			{"O","X","X"},
			{"-","-","-"}
	};
	
	@Test
	public void testCheckrow() {
		assertEquals(-1, twmxg154.checkrow("X", matrix2));
		assertEquals(-1, twmxg154.checkrow("X", matrix3));
		assertEquals(0, twmxg154.checkrow("X", matrix1));
	}

	@Test
	public void testCheckcolumn() {
		assertEquals(2, twmxg154.checkcolumn("X", matrix2));
		assertEquals(-1, twmxg154.checkcolumn("X", matrix3));
	}

	@Test
	public void testCheckDiagonal() {
		assertEquals(1, twmxg154.checkDiagonal("X", matrix1));
		assertEquals(1, twmxg154.checkDiagonal("X", matrix4));
	}

	
	@Test
	public void testInit1() {
		String inputData = "X\nXX-\n-XO\nOO-\n";
		System.setIn(new java.io.ByteArrayInputStream(inputData.getBytes()));
		outContent.reset();
		twmxg154.init();
		assertEquals("XXX\r\n-XO\r\nOO-\r\n", outContent.toString());
	}
	
	@Test
	public void testInit2() {
		String inputData = "O\nO-X\n-OX\n---\n";
		System.setIn(new java.io.ByteArrayInputStream(inputData.getBytes()));
		outContent.reset();
		twmxg154.init();
		assertEquals("O-X\r\n-OX\r\n--O\r\n", outContent.toString());
	}
	
	@Test
	public void testInit3() {
		String inputData = "X\n--O\nOXX\n---\n";
		System.setIn(new java.io.ByteArrayInputStream(inputData.getBytes()));
		outContent.reset();
		twmxg154.init();
		assertEquals("No Winning Move!\r\n", outContent.toString());
	}
}
