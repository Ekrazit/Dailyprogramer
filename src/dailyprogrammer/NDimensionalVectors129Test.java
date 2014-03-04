package dailyprogrammer;

import static org.junit.Assert.*;

import org.junit.Test;

public class NDimensionalVectors129Test {
	NDimensionalVectors129 ndv129 =  new NDimensionalVectors129();

	@Test
	public void testDlzka() {
		vektory vek = new vektory();
		vek.addToVektory(84.82f);
		vek.addToVektory(121f);
		vek.addToVektory(467.05f);
		vek.addToVektory(142.14f);
		vek.addToVektory(592.55f);
		vek.addToVektory(971.79f);
		vek.addToVektory(795.33f);
		assertEquals("1479.262\r\n", ndv129.dlzka(vek));
	}

	@Test
	public void testNormallize() {
		vektory vek = new vektory();
		vek.addToVektory(1.2f);
		vek.addToVektory(3.4f);
		assertEquals("0.333 0.943 \n", ndv129.normallize(vek));
	}

	@Test
	public void testDotProdukt() {
		vektory vek1 = new vektory();
		vek1.addToVektory(1.2f);
		vek1.addToVektory(3.4f);
		vektory vek2 = new vektory();
		vek2.addToVektory(1f);
		vek2.addToVektory(1f);
		assertEquals("4.600\r\n", ndv129.dotProdukt(vek1, vek2));
	}

}
