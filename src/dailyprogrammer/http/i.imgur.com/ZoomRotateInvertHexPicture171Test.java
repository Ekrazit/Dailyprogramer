package dailyprogramer;

import org.junit.Assert;
import org.junit.Test;

public class ZoomRotateInvertHexPicture171Test {
	
	ZoomRotateInvertHexPicture171 zrihp171 = new ZoomRotateInvertHexPicture171();

	@Test
	public void zoomTest() {
		
		String[][] inmatrix1 = {
				{"x","#"},
				{"x","#"}};
		
		String[][] outmatrix1 = {
				{"x","x","#","#"},
				{"x","x","#","#"},
				{"x","x","#","#"},
				{"x","x","#","#"}};

		Assert.assertArrayEquals(outmatrix1, zrihp171.zoom(inmatrix1));
	}
	
	@Test
	public void rotateTest(){

		String[][] inmatrix1 = {
				{"x","#"},
				{"x","#"},
				{"#","x"}};
		String[][] outmatrix1 = {
				{"#","x","x"},
				{"x","#","#"}};

		Assert.assertArrayEquals(outmatrix1, zrihp171.rotate(inmatrix1));

		String[][] inmatrix2 = {
				{"x"},
				{"x"},
				{"#"}};
		String[][] outmatrix2 = {
				{"#","x","x"}};

		Assert.assertArrayEquals(outmatrix2, zrihp171.rotate(inmatrix2));
	}
	
	@Test
	public void invertTest(){
		String[][] inmatrix = {{"x","#"},{"#","x"}};
		String[][] outmatrix = {{"#","x"},{"x","#"}};
		Assert.assertArrayEquals(outmatrix, zrihp171.invert(inmatrix));
	}
}
