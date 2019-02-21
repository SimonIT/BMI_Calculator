package tests;

import backend.BmiCalculator;
import backend.BmiException;
import backend.Sex;
import backend.WeightCategory;
import org.junit.Test;

import java.lang.reflect.Array;

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
        bmi.setSize(180);
        int[][] testArray = {{18,58},{19,61},{20,64},{23,74},{24,77},{25,81},{26,84},{29,93},{30,97},{31,100},{32,103},{33,106},{34,110},{35,113}};
        for (int[] currentCase : testArray){
            bmi.setWeight(currentCase[1]);

          //todo assertEquals
        }
    }

}