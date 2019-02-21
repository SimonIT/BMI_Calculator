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
    public void testIfMaleObeseBmiIsCorrect() {
        //bmi = 25,93 | category = Overweight
        BmiCalculator bmi = new BmiCalculator();
        bmi.setSex(Sex.MALE);
        bmi.setAge(18);
        bmi.setWeight(84);
        bmi.setSize(180);

        try {
            assertEquals("Overweight Bmi", 25.93, bmi.getBmi(), 0.1);
        } catch (BmiException e) {
            fail("Exception occured");
            e.printStackTrace();
        }

        assertEquals("Bmi should be Overweigth", WeightCategory.OVERWEIGHT, bmi.getCategory());
    }

    @Test
    public void testIfMaleOverweightBmiIsCorrect() {
        //bmi = 25,93 | category = Overweight
        BmiCalculator bmi = new BmiCalculator();
        bmi.setSex(Sex.MALE);
        bmi.setAge(18);
        bmi.setWeight(84);
        bmi.setSize(180);

        try {
            assertEquals("Overweight Bmi", 25.93, bmi.getBmi(), 0.1);
        } catch (BmiException e) {
            fail("Exception occured");
            e.printStackTrace();
        }

        assertEquals("Bmi should be Overweigth", WeightCategory.OVERWEIGHT, bmi.getCategory());
    }

    @Test
    public void testIfMaleNormalBmiIsCorrect() {
        //bmi = 23,15 | category = normal
        BmiCalculator bmi = new BmiCalculator();
        bmi.setSex(Sex.MALE);
        bmi.setAge(18);
        bmi.setWeight(75);
        bmi.setSize(180);

        try {
            assertEquals("Normaler Bmi", 23.15, bmi.getBmi(), 0.1);
        } catch (BmiException e) {
            fail("Exception occured");
            e.printStackTrace();
        }

        assertEquals("Bmi should be Normal", WeightCategory.NORMAL, bmi.getCategory());
    }

    @Test
    public void testIfWithoutAgeCategoryIsNotCalculateable() {
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

    @Test
    public void testIfSizeNegativeOrZeroThrowsException() {
        BmiCalculator bmi = new BmiCalculator();
        bmi.setWeight(84);
        bmi.setAge(30);
        bmi.setSex(Sex.MALE);

        try {
            bmi.getBmi();
        } catch (BmiException e) {
            assertEquals(e.getMessage(), "Size is <= zero!");
        }
    }

    @Test
    public void testIfWeightNegativeThrowsException() {
        BmiCalculator bmi = new BmiCalculator();
        bmi.setWeight(-1);
        bmi.setSize(180);
        bmi.setAge(30);
        bmi.setSex(Sex.MALE);

        try {
            bmi.getBmi();
        } catch (BmiException e) {
            assertEquals( "Weight is < zero!", e.getMessage());
        }
    }

    @Test
    public void testIfBmiIsCorrect(){
        BmiCalculator bmi = new BmiCalculator();
        bmi.setSex(Sex.MALE);
        bmi.setAge(18);
        for (int i=0; i<200; i++){
            bmi.setWeight(i);
            for (int y=1; y<300; y++ ){
                bmi.setSize(y);
                try {
                    assertEquals("Overweight Bmi", (i/(Math.pow(y/100.0,2))), bmi.getBmi(), 0.1);
                } catch (BmiException e) {
                    fail("Exception occured");
                    e.printStackTrace();
                }
            }

        }
    }
}