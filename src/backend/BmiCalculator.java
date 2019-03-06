package backend;

import java.io.Serializable;

public class BmiCalculator implements BmiCalcInterface, Serializable {
    private double bmi = 0;
    private double size = 0;
    private Sex sex = Sex.UNKNOWN;
    private int age = 0;
    private int weight = 0;

    public BmiCalculator() {
        // constructor
    }

    @Override
    public double getBmi() throws BmiException {
        if (this.size <= 0) {
            throw new BmiException("Size is <= zero!");
        }
        if (this.weight < 0) {
            throw new BmiException("Weight is < zero!");
        }
        this.bmi = Math.floor(this.weight / Math.pow(this.size / 100, 2));
        return this.bmi;
    }

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
    public WeightCategory getCategory() {
        return WeightCategory.getCategory(this.bmi, this.age, this.sex);
    }

    @Override
    public String getCategoryAsString() {
        return getCategory().name();
    }
}
