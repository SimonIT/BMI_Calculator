package backend;

public interface BmiCalcInterface {

    double getBmi() throws BmiException;

    Sex getSex();

    void setSex(Sex sex);

    int getAge();

    void setAge(int age);

    int getSize();

    void setSize(int size);

    int getWeight();

    void setWeight(int weight);

    WeightCategory getCategory();

    String getCategoryAsString();


} 
