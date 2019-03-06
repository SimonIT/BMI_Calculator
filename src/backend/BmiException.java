/*
 * Name: Falko Tschernay, Joel Pitzler                           Klasse: DQI 16 *
 * Prog.Name: Tschernay_Pitzler_BMI_Calculator                     BmiException *
 * Version: 1.0 vom 06.03.2019                                                  *
 * Progammiersprache: Java  Version 1.8.0_191                                   *
 */
package backend;

/**
 * short description
 *
 * @author wolke
 * @version 1.0, 28.09.2012
 */
public class BmiException extends Exception {

    /**
     * @param reason reason for the exception
     */
    public BmiException(String reason) {
        super(reason);
    }

}
