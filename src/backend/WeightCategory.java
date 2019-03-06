/*
 * Name: Falko Tschernay, Joel Pitzler                           Klasse: DQI 16 *
 * Prog.Name: Tschernay_Pitzler_BMI_Calculator                   WeightCategory *
 * Version: 1.0 vom 06.03.2019                                                  *
 * Progammiersprache: Java  Version 1.8.0_191                                   *
 */

package backend;

public enum WeightCategory {
    NOT_CALCULATABLE, UNDERWEIGHT, NORMAL, OVERWEIGHT,
    OBESE;

    /***
     * BMI getrennt nach Geschlecht und Alter
     *
     * Männer
     * ab 18 Jahre  <19, 19-24, 25-31, >31
     * ab 65 Jahre  <25, 25-30, 31-34, >34
     *
     * Frauen
     * ab 18 Jahre  <20, 20-25, 26-31, >31
     * ab 65 Jahre  <24, 24-29, 30-33, >33
     *
     *Es gelten die Grenzwerte. Der Nachkommateil ist abzuschneiden.
     */
    //age groups and limits of these groups
    static final int OLD = 65;
    static final int[] GROUP_OLD_F = {24, 29, 33};
    static final int[] GROUP_OLD_M = {25, 30, 34};

    static final int YOUNG = 18;
    static final int[] GROUP_YOUNG_F = {20, 25, 31};
    static final int[] GROUP_YOUNG_M = {19, 24, 31};


    public static WeightCategory getCategory(double bmi, int age, Sex sex) { //get Category
        WeightCategory result = WeightCategory.NOT_CALCULATABLE; //set Category to NOT_CALCULATEABLE (case that no Category found)

        if (age >= OLD) {
            if (sex == Sex.FEMALE) {
                result = filter(bmi, GROUP_OLD_F); //filter the bmi in the old female group
            } else if (sex == Sex.MALE){
                result = filter(bmi, GROUP_OLD_M); //filter the bmi in the old male group
            }

        } else if (age >= YOUNG) {
            if (sex == Sex.FEMALE) {
                result = filter(bmi, GROUP_YOUNG_F); //filter the bmi in the young female group

            } else if (sex == Sex.MALE){
                result = filter(bmi, GROUP_YOUNG_M); //filter the bmi in the young male group
            }
        }
        return result;
    }

    private static WeightCategory filter(double bmi, int[] group) {
        WeightCategory result = NOT_CALCULATABLE;
        if (bmi < group[0]) {
            result = UNDERWEIGHT;
        } else if (bmi <= group[1]) {
            result = NORMAL;
        } else if (bmi <= group[2]) {
            result = OVERWEIGHT;
        } else if (bmi > group[2]) {
            result = OBESE;
        }
        return result;
    }

}

