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
     * Es gelten die Grenzwerte. Der Nachkommateil ist abzuschneiden.
     */
    static final int OLD = 65;
    static final int[] group_old_f = {24, 29, 33};

    static final int[] group_old_m = {25, 30, 34};

    static final int YOUNG = 18;

    static final int[] group_young_f = {20, 25, 31};

    static final int[] group_young_m = {19, 24, 31};


    public static WeightCategory getCategory(double bmi, int age, Sex sex) {
        WeightCategory result = WeightCategory.NOT_CALCULATABLE;
        if (age >= OLD) {
            if (sex == Sex.FEMALE) {
                result = filter(bmi, group_old_f, result);
            } else if (sex == Sex.MALE){
                result = filter(bmi, group_old_m, result);
            }

        } else if (age >= YOUNG) {
            if (sex == Sex.FEMALE) {
                result = filter(bmi, group_young_f, result);

            } else if (sex == Sex.MALE){
                result = filter(bmi, group_young_m, result);
            }
        }
        return result;
    }

    private static WeightCategory filter(double bmi, int[] group, WeightCategory result) {
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

