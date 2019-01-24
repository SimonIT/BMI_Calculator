package backend;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeightCategoryTest {

	@Test
	void testNotCalcculatable() {
		assertEquals(WeightCategory.NOT_CALCULATABLE, WeightCategory.getCategory(18, -1, null));
	}

	@Test
	void testUnderweight() {
		assertEquals(WeightCategory.UNDERWEIGHT, WeightCategory.getCategory(18, 18, Sex.MALE));
	}
}
