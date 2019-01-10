package backend;

public enum WeightCategory {
    NOT_CALCULATABLE, UNDERWEIGHT, NORMAL, OVERWEIGHT,
    OBESE, SEVERELY_OBESE;

    static WeightCategory getCategory(double bmi, int age, Sex sex) {
        if (age >= 65) {
            switch (sex) {
                case FEMALE:
                    if (bmi <= 24) {
                        return UNDERWEIGHT;
                    } else if (bmi <= 29) {
                        return NORMAL;
                    } else if (bmi <= 33) {
                        return OVERWEIGHT;
                    } else if (bmi >= 33) {
                        return OBESE;
                    }
                    break;
                case MALE:
                    if (bmi <= 25) {
                        return UNDERWEIGHT;
                    } else if (bmi <= 30) {
                        return NORMAL;
                    } else if (bmi <= 34) {
                        return OVERWEIGHT;
                    } else if (bmi >= 34) {
                        return OBESE;
                    }
                    break;
            }
        } else if (age >= 18) {
            switch (sex) {
                case FEMALE:
                    if (bmi <= 20) {
                        return UNDERWEIGHT;
                    } else if (bmi <= 25) {
                        return NORMAL;
                    } else if (bmi <= 30) {
                        return OVERWEIGHT;
                    } else if (bmi >= 31) {
                        return OBESE;
                    }
                    break;
                case MALE:
                    if (bmi <= 19) {
                        return UNDERWEIGHT;
                    } else if (bmi <= 24) {
                        return NORMAL;
                    } else if (bmi <= 30) {
                        return OVERWEIGHT;
                    } else if (bmi >= 31) {
                        return OBESE;
                    }
                    break;
            }
        }
        return NOT_CALCULATABLE;
    }
}
