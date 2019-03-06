/*
 * Name: Falko Tschernay, Joel Pitzler                           Klasse: DQI 16 *
 * Prog.Name: Tschernay_Pitzler_BMI_Calculator                      NumberField *
 * Version: 1.0 vom 06.03.2019                                                  *
 * Progammiersprache: Java  Version 1.8.0_191                                   *
 */

package frontend;

import javafx.scene.control.TextField;

public class NumberField extends TextField {
    @Override
    public void replaceText (int start,int end, String text){
        if(text.matches("[0-9]")|| text.trim().equals("")){
            super.replaceText(start,end,text);
        }
    }
}
