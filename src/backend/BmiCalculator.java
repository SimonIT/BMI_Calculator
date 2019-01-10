package backend;

import java.io.Serializable;

public class BmiCalculator implements BmiCalcInterface, Serializable {
    private double bmi, size;
    private Sex sex;
    private int age, weight;

    public BmiCalculator() {
    }

    BmiCalculator(Sex sex, int age, int weight, int size) {
        this.sex = sex;
        this.age = age;
        this.weight = weight;
        this.size = size;
    }

    @Override
    public double getBmi() throws BmiException {
        if (this.size == 0)
            throw new BmiException("Size is zero!");
        return this.bmi = this.weight / Math.pow(this.size, 2);
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
        return (int) Math.round(this.size * 100);
    }

    @Override
    public void setSize(int size) {
        this.size = (double) size / 100;
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
