package tests;

import backend.BmiCalculator;
import backend.BmiException;
import backend.Sex;
import backend.WeightCategory;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class BmiCalculatorTest {

    @Test
    public void testIfOverweightBmiIsCorrect() {
        BmiCalculator bmi = new BmiCalculator(Sex.MALE,30, 84, 180);
        //bmi = 25,93 | category = normal

        try {
            assertEquals("Normaler Bmi", 25.93, bmi.getBmi(), 0.1);
        } catch (BmiException e) {
            fail("Exception occured");
            e.printStackTrace();
        }

        assertEquals("Bmi should be Overweigth", WeightCategory.OVERWEIGHT, bmi.getCategory());
    }

    @Test
    public void testIfWithoutAgeCategoryIsNotCalculateable(){
        BmiCalculator bmi = new BmiCalculator();
        bmi.setWeight(84);
        bmi.setSize(180);
        bmi.setSex(Sex.MALE);

        try {
            assertEquals("Normaler Bmi", 25.93, bmi.getBmi(), 0.1);
        } catch (BmiException e) {
            fail("Exception occured");
            e.printStackTrace();
        }

        assertEquals("Bmi should be NotCalculateable", WeightCategory.NOT_CALCULATABLE, bmi.getCategory());

    }

}