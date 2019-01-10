package backend;

public enum WeightCategory {
    NOT_CALCULATABLE, UNDERWEIGHT, NORMAL, OVERWEIGHT,
    OBESE, SEVERELY_OBESE;

    static WeightCategory getCategory(double bmi, int age, Sex sex) {
        if (age == 10) {
            switch (sex) {
                case FEMALE:
                    if (bmi <= 14.2) {
                        return UNDERWEIGHT;
                    } else if (bmi >= 14.3 && bmi <= 20.6) {
                        return NORMAL;
                    } else if (bmi >= 20.7 && bmi <= 23.3) {
                        return OVERWEIGHT;
                    } else if (bmi >= 23.4) {
                        return OBESE;
                    }
                    break;
                case MALE:
                    if (bmi <= 14.6) {
                        return UNDERWEIGHT;
                    } else if (bmi >= 14.7 && bmi <= 21.3) {
                        return NORMAL;
                    } else if (bmi >= 21.4 && bmi <= 24.9) {
                        return OVERWEIGHT;
                    } else if (bmi >= 25) {
                        return OBESE;
                    }
                    break;
            }
        } else if (age >= 25 && age <= 34) {
            switch (sex) {
                case FEMALE:
                    if (bmi <= 19) {
                        return UNDERWEIGHT;
                    } else if (bmi >= 19 && bmi <= 24) {
                        return NORMAL;
                    } else if (bmi >= 25 && bmi <= 30) {
                        return OVERWEIGHT;
                    } else if (bmi >= 31) {
                        return OBESE;
                    }
                    break;
                case MALE:
                    if (bmi <= 20) {
                        return UNDERWEIGHT;
                    } else if (bmi >= 20 && bmi <= 25) {
                        return NORMAL;
                    } else if (bmi >= 26 && bmi <= 30) {
                        return OVERWEIGHT;
                    } else if (bmi >= 31) {
                        return OBESE;
                    }
                    break;
            }
        } else if (age >= 65 && age <= 90) {
            switch (sex) {
                case FEMALE:
                    if (bmi <= 25) {
                        return UNDERWEIGHT;
                    } else if (bmi >= 25 && bmi <= 30) {
                        return NORMAL;
                    } else if (bmi >= 31 && bmi <= 34) {
                        return OVERWEIGHT;
                    } else if (bmi >= 34) {
                        return OBESE;
                    }
                    break;
                case MALE:
                    if (bmi <= 24) {
                        return UNDERWEIGHT;
                    } else if (bmi >= 24 && bmi <= 29) {
                        return NORMAL;
                    } else if (bmi >= 30 && bmi <= 33) {
                        return OVERWEIGHT;
                    } else if (bmi >= 33) {
                        return OBESE;
                    }
                    break;
            }
        }
        return NOT_CALCULATABLE;
    }
}
