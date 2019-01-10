package frontend;

import backend.BmiCalculator;
import backend.BmiException;
import backend.Sex;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class BmiController implements Initializable {

    BmiCalculator bmiCalc = new BmiCalculator();

    @FXML
    ComboBox<Sex> sexComboBox;
    @FXML
    NumberField ageTextField;
    @FXML
    NumberField weightTextField;
    @FXML
    NumberField sizeTextField;
    @FXML
    Button calculateButton;
    @FXML
    Label resultLabel;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        sexComboBox.setItems(FXCollections.observableList(Arrays.asList(Sex.values())));
    }

    public void calculate() throws BmiException {
        if (!ageTextField.getText().equals("") & !sizeTextField.getText().equals("") & !weightTextField.getText().equals("")){
            bmiCalc.setAge(Integer.parseInt(ageTextField.getText()));
            bmiCalc.setSize(Integer.parseInt(sizeTextField.getText()));
            bmiCalc.setWeight(Integer.parseInt(weightTextField.getText()));

            resultLabel.setText(""+bmiCalc.getBmi());
        }

    }
}
