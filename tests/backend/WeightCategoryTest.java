package backend;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeightCategoryTest {

	@Test
	void getCategory() {
		assertEquals(WeightCategory.UNDERWEIGHT, WeightCategory.getCategory(18, 18, Sex.MALE));
	}
}
