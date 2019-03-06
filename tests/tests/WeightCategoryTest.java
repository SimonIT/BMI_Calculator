/*
 * Name: Falko Tschernay, Joel Pitzler                           Klasse: DQI 16 *
 * Prog.Name: Tschernay_Pitzler_BMI_Calculator               WeightCategoryTest *
 * Version: 1.0 vom 06.03.2019                                                  *
 * Progammiersprache: Java  Version 1.8.0_191                                   *
 */

package tests;

import backend.BmiCalculator;
import backend.BmiException;
import backend.Sex;
import backend.WeightCategory;
import org.junit.Test;

import static org.junit.Assert.*;

public class WeightCategoryTest {

    @Test
    public void testIfOver64FemaleIsCorrect() {
        // [[bmiOF -> CATEGORY]
        // [[23,UNDERWEIGHT],[24,NORMAL],[29,NORMAL],[30,OVERWEIGHT],[33,OVERWEIGHT],[34,OBESE]]
        int[] testArray = {23, 24, 29, 30, 33, 34};
        WeightCategory[] answerArray = {WeightCategory.UNDERWEIGHT, WeightCategory.NORMAL,
                WeightCategory.NORMAL, WeightCategory.OVERWEIGHT, WeightCategory.OVERWEIGHT, WeightCategory.OBESE};

        for (int i = 0; i < testArray.length; i++) {
            assertEquals("Category Correct", WeightCategory.getCategory(testArray[i], 65, Sex.FEMALE), answerArray[i]);
        }

    }

    @Test
    public void testIfOver64MaleIsCorrect() {
        // [[bmiOF -> CATEGORY]
        // [[19,UNDERWEIGHT],[25,NORMAL],[30,NORMAL],[31,OVERWEIGHT],[34,OVERWEIGHT],[35,OBESE]]
        int[] testArray = {24, 25, 30, 31, 34, 35};
        WeightCategory[] answerArray = {WeightCategory.UNDERWEIGHT, WeightCategory.NORMAL,
                WeightCategory.NORMAL, WeightCategory.OVERWEIGHT, WeightCategory.OVERWEIGHT, WeightCategory.OBESE};

        for (int i = 0; i < testArray.length; i++) {
            assertEquals("Category Correct", WeightCategory.getCategory(testArray[i], 65, Sex.MALE), answerArray[i]);
        }

    }

    @Test
    public void testIfUnder64FemaleIsCorrect() {
        // [[bmiOF -> CATEGORY]
        // [[19,UNDERWEIGHT],[20,NORMAL],[25,NORMAL],[26,OVERWEIGHT],[31,OVERWEIGHT],[32,OBESE]]
        int[] testArray = {19, 20, 25, 26, 31, 32};
        WeightCategory[] answerArray = {WeightCategory.UNDERWEIGHT, WeightCategory.NORMAL,
                WeightCategory.NORMAL, WeightCategory.OVERWEIGHT, WeightCategory.OVERWEIGHT, WeightCategory.OBESE};

        for (int i = 0; i < testArray.length; i++) {
            assertEquals("Category Correct", WeightCategory.getCategory(testArray[i], 20, Sex.FEMALE), answerArray[i]);
        }

    }

    @Test
    public void testIfUnder64MaleIsCorrect() {
        // [[bmiOF -> CATEGORY]
        // [[18,UNDERWEIGHT],[19,NORMAL],[24,NORMAL],[25,OVERWEIGHT],[31,OVERWEIGHT],[32,OBESE]]
        int[] testArray = {18, 19, 24, 25, 31, 32};
        WeightCategory[] answerArray = {WeightCategory.UNDERWEIGHT, WeightCategory.NORMAL,
                WeightCategory.NORMAL, WeightCategory.OVERWEIGHT, WeightCategory.OVERWEIGHT, WeightCategory.OBESE};

        for (int i = 0; i < testArray.length; i++) {
            assertEquals("Category Correct", WeightCategory.getCategory(testArray[i], 20, Sex.MALE), answerArray[i]);
        }

    }

    @Test
    public void testIfWithoutAgeOrAgeSmaller18CategoryIsNotCalculateable() {
        BmiCalculator bmi = new BmiCalculator();
        bmi.setWeight(84);
        bmi.setSize(180);
        bmi.setSex(Sex.MALE);
        try {
            bmi.getBmi();
        } catch (BmiException e) {
            e.printStackTrace();
        }
        assertEquals("Category without Age should be NotCalculateable", WeightCategory.NOT_CALCULATABLE, bmi.getCategory());

        bmi.setAge(10);
        assertEquals("Category with Age<18 should be NotCalculateable", WeightCategory.NOT_CALCULATABLE, bmi.getCategory());
    }

    @Test
    public void testIfWithoutSexCategoryIsNotCalculateable() {
        BmiCalculator bmi = new BmiCalculator();
        bmi.setWeight(84);
        bmi.setSize(180);
        bmi.setSex(Sex.UNKNOWN);
        bmi.setAge(20);
        try {
            bmi.getBmi();
        } catch (BmiException e) {
            e.printStackTrace();
        }
        assertEquals("Category without Age should be NotCalculateable", WeightCategory.NOT_CALCULATABLE, bmi.getCategory());
    }

}