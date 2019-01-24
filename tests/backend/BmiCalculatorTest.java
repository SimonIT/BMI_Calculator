package backend;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class BmiCalculatorTest {

	@Test
	void getBmi() throws BmiException {
		assertEquals(24.7, new BmiCalculator(null, 18, 80, 180).getBmi(), 0.1);

		assertEquals(0, new BmiCalculator(null, 18, 80, 0).getBmi());

		assertThrows(BmiException.class, () -> new BmiCalculator(null, 18, 80, -1).getBmi());
		assertThrows(BmiException.class, () -> new BmiCalculator(null, 18, -1, 180).getBmi());
		assertThrows(BmiException.class, () -> new BmiCalculator(null, 18, -1, -1).getBmi());
	}
}
