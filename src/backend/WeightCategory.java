package backend;

public enum WeightCategory {
    NOT_CALCULATABLE, UNDERWEIGHT, NORMAL, OVERWEIGHT,
    OBESE, SEVERELY_OBESE;

    /***
     * BMI getrennt nach Geschlecht und Alter
     *
     * Männer
     * ab 18 Jahre  <19, 19-24, 25-30, >31
     * ab 65 Jahre  <25, 25-30, 31-34, >34
     *
     * Frauen
     * ab 18 Jahre  <20, 20-25, 26-30, >31
     * ab 65 Jahre  <24, 24-29, 30-33, >33
     *
     * Es gelten die Grenzwerte. Der Nachkommateil ist abzuschneiden.
     */
    static WeightCategory getCategory(double bmi, int age, Sex sex) {
        if (age >= 65) {
            switch (sex) {
                case FEMALE:
                    if (bmi < 24) {
                        return UNDERWEIGHT;
                    } else if (bmi < 30) {
                        return NORMAL;
                    } else if (bmi < 33) {
                        return OVERWEIGHT;
                    } else {
                        return OBESE;
                    }
                case MALE:
                    if (bmi < 25) {
                        return UNDERWEIGHT;
                    } else if (bmi < 31) {
                        return NORMAL;
                    } else if (bmi < 34) {
                        return OVERWEIGHT;
                    } else {
                        return OBESE;
                    }
            }
        } else if (age >= 18) {
            switch (sex) {
                case FEMALE:
                    if (bmi < 20) {
                        return UNDERWEIGHT;
                    } else if (bmi < 26) {
                        return NORMAL;
                    } else if (bmi < 31) {
                        return OVERWEIGHT;
                    } else {
                        return OBESE;
                    }
                case MALE:
                    if (bmi < 19) {
                        return UNDERWEIGHT;
                    } else if (bmi < 25) {
                        return NORMAL;
                    } else if (bmi < 31) {
                        return OVERWEIGHT;
                    } else {
                        return OBESE;
                    }
            }
        }
        return NOT_CALCULATABLE;
    }
}
