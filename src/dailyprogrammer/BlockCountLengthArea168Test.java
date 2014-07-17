package dailyprogramer;

import java.util.ArrayList;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;



import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BlockCountLengthArea168Test {

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
	public void classBlockTest1() {
		ArrayList<Integer[]> bloky = new ArrayList<Integer[]>();
		bloky.add(new Integer[] { 5, 5 });
		Block blk = new Block("#", bloky);
		Assert.assertEquals(40, blk.getObvod());
		Assert.assertEquals(100, blk.getPlocha());
		blk.addblock(6, 5);
		Assert.assertEquals(true, blk.isPart(6, 5));
		Assert.assertEquals(60, blk.getObvod());
		Assert.assertEquals(200, blk.getPlocha());
		blk.addblock(5, 4);
		Assert.assertEquals(80, blk.getObvod());
		Assert.assertEquals(false, blk.isPart(3, 7));
		Assert.assertEquals(300, blk.getPlocha());
	}

	@Test
	public void pridajdonovehoblokuTest() {
		BlockCountLengthArea168 bcla = new BlockCountLengthArea168();

	}

	@Test
	public void isPartofmatrixTest() {
		String inputData = "****\n0000\n****\n####\n\n";
		System.setIn(new java.io.ByteArrayInputStream(inputData.getBytes()));
		BlockCountLengthArea168 bcla = new BlockCountLengthArea168();
		bcla.read();
		Assert.assertEquals(false, bcla.isPartofMatrix(-1, 0));
		Assert.assertEquals(false, bcla.isPartofMatrix(0, -1));
		Assert.assertEquals(true, bcla.isPartofMatrix(0, 0));
		Assert.assertEquals(false, bcla.isPartofMatrix(0, 4));
	}
	
	@Test
	public void inoutTest1(){
		String inputData = "****\n0000\n****\n####\n\n";
		System.setIn(new java.io.ByteArrayInputStream(inputData.getBytes()));
		BlockCountLengthArea168 bcla2 = new BlockCountLengthArea168();
		bcla2.init();
		Assert.assertEquals("#: Total SF (400), Total Circumference LF (100) - Found 1 block\r\n0: Total SF (400), Total Circumference LF (100) - Found 1 block\r\n*: Total SF (800), Total Circumference LF (200) - Found 2 block\r\n", outContent.toString());
	}
	
	@Test
	public void inoutTest2(){
		String inputData = "*0*#\n*0*#\n*0*#\n*0*#\n\n";
		System.setIn(new java.io.ByteArrayInputStream(inputData.getBytes()));
		BlockCountLengthArea168 bcla2 = new BlockCountLengthArea168();
		bcla2.init();
		Assert.assertEquals("#: Total SF (400), Total Circumference LF (100) - Found 1 block\r\n0: Total SF (400), Total Circumference LF (100) - Found 1 block\r\n*: Total SF (800), Total Circumference LF (200) - Found 2 block\r\n", outContent.toString());
	}
	
	
	@Test
	public void inoutTest3(){
		String inputData = "000\n000\n000\n\n";
		System.setIn(new java.io.ByteArrayInputStream(inputData.getBytes()));
		BlockCountLengthArea168 bcla2 = new BlockCountLengthArea168();
		bcla2.init();
		Assert.assertEquals("0: Total SF (900), Total Circumference LF (120) - Found 1 block\r\n", outContent.toString());
	}
	
}
