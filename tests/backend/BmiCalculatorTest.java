package backend;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class BmiCalculatorTest {

    @Test
    void testBmiCalculation() throws BmiException {
        assertEquals(24.7, new BmiCalculator(80, 180).getBmi(), 0.1);
        assertEquals(1, new BmiCalculator(1, 100).getBmi(), 0.1);
        assertEquals(0, new BmiCalculator(0, 180).getBmi(), 0.1);
    }

    @Test
    void testBmiExceptionThrowing() {
        assertThrows(BmiException.class, () -> new BmiCalculator(80, -1).getBmi());
        assertThrows(BmiException.class, () -> new BmiCalculator(-1, 180).getBmi());
        assertThrows(BmiException.class, () -> new BmiCalculator(-1, -1).getBmi());
    }

    @Test
    void testBmiSpecialCases() throws BmiException {
        assertEquals(0, new BmiCalculator(80, 0).getBmi());
    }
}
