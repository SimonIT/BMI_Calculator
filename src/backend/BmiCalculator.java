package backend;

import java.io.Serializable;

public class BmiCalculator implements BmiCalcInterface, Serializable {
    private double size;
    private Sex sex;
    private int age, weight;

    public BmiCalculator() {
    }

    public BmiCalculator(int weight, int size) {
        this.weight = weight;
        this.size = size / 100.0;
    }

    @Override
    public double getBmi() throws BmiException {
        if (this.size == 0)
            return 0;
        if (this.size < 0 || this.weight < 0)
            throw new BmiException("Weight or size negative!");
        return this.weight / Math.pow(this.size, 2);
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
        this.size = (double) size / 100.0;
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
        try {
            return WeightCategory.getCategory(getBmi(), this.age, this.sex);
        } catch (BmiException e) {
            return WeightCategory.NOT_CALCULATABLE;
        }
    }

    @Override
    public String getCategoryAsString() {
        return getCategory().name();
    }
}
