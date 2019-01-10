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
    @FXML
    Label categoryLabel;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        sexComboBox.setItems(FXCollections.observableList(Arrays.asList(Sex.values())));
        ageTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            if(!ageTextField.getText().isEmpty()) {
                bmiCalc.setAge(Integer.parseInt(ageTextField.getText()));
            }
        });
        weightTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            if(!weightTextField.getText().isEmpty()) {
                bmiCalc.setWeight(Integer.parseInt(weightTextField.getText()));
            }
        });
        sizeTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            if(!sizeTextField.getText().isEmpty()) {
                bmiCalc.setSize(Integer.parseInt(sizeTextField.getText()));
            }
        });
    }

    public void calculate() throws BmiException {
        resultLabel.setText(String.valueOf(bmiCalc.getBmi()));
    }
}
