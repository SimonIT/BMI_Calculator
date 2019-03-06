/*
 * Name: Falko Tschernay, Joel Pitzler                           Klasse: DQI 16 *
 * Prog.Name: Tschernay_Pitzler_BMI_Calculator                    BmiCalculator *
 * Version: 1.0 vom 06.03.2019                                                  *
 * Progammiersprache: Java  Version 1.8.0_191                                   *
 */
package backend;

import java.io.Serializable;

public class BmiCalculator implements BmiCalcInterface, Serializable {
    private double bmi = 0;
    private double size = 0;
    private Sex sex = Sex.UNKNOWN;
    private int age = 0;
    private int weight = 0;

    @Override
    public double getBmi() throws BmiException { //valiade size and weight and calculate bmi
        if (this.size <= 0) {
            throw new BmiException("Size is <= zero!");
        }
        if (this.weight < 0) {
            throw new BmiException("Weight is < zero!");
        }
        this.bmi = Math.floor(this.weight / Math.pow(this.size / 100, 2));
        return this.bmi;
    }

    // basic getter and setter
    @Override
    public Sex getSex() {
        return this.sex;
    }

    @Override
    public void setSex(Sex sex) {
        this.sex = sex;
    }

    @Override
    public int getAge() {
        return this.age;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int getSize() {
        return (int) Math.round(this.size);
    }

    @Override
    public void setSize(int size) {
        this.size = (double) size;
    }

    @Override
    public int getWeight() {
        return this.weight;
    }

    @Override
    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public WeightCategory getCategory() { //get category with  bmi, age and sex
        return WeightCategory.getCategory(this.bmi, this.age, this.sex);
    }

    @Override
    public String getCategoryAsString() {
        return getCategory().name();
    }
}
