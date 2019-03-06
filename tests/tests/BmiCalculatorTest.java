package tests;

import backend.BmiCalculator;
import backend.BmiException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class BmiCalculatorTest {

    @Test
    public void testIfSizeZeroThrowsException() {
        BmiCalculator bmi = new BmiCalculator();
        bmi.setWeight(84);
        bmi.setSize(0);

        try {
            bmi.getBmi();
        } catch (BmiException e) {
            assertEquals(e.getMessage(), "Size is <= zero!");
        }
    }

    @Test
    public void testIfSizeNegativeThrowsException() {
        BmiCalculator bmi = new BmiCalculator();
        bmi.setWeight(84);
        bmi.setSize(-1);

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

        try {
            bmi.getBmi();
        } catch (BmiException e) {
            assertEquals("Weight is < zero!", e.getMessage());
        }
    }

    @Test //testing all bmi's that are relevant for category (or "rendom" test cases)
    public void testIfBmiIsCorrect() {
        BmiCalculator bmi = new BmiCalculator();
        bmi.setSize(180);
        int[][] testArray = {{18, 59}, {19, 62}, {20, 65}, {23, 75}, {24, 78}, {25, 82}, {26, 85}, {29, 94}, {30, 98}, {31, 101}, {32, 104}, {33, 107}, {34, 111}, {35, 114}};
        for (int[] currentCase : testArray) {
            bmi.setWeight(currentCase[1]);

            try {
                assertEquals("Bmi Correct", currentCase[0], bmi.getBmi(), 0.1);
            } catch (BmiException e) {
                fail("Exception occured");
                e.printStackTrace();
            }
        }
    }

}