package backend;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class BmiCalculatorTest {

	@Test
	void getBmi() throws BmiException {
		assertEquals(24.7, new BmiCalculator(Sex.MALE, 18, 80, 180).getBmi(), 0.1);
	}
}
