/*
 * Name: Falko Tschernay, Joel Pitzler                           Klasse: DQI 16 *
 * Prog.Name: Tschernay_Pitzler_BMI_Calculator                    BmiController *
 * Version: 1.0 vom 06.03.2019                                                  *
 * Progammiersprache: Java  Version 1.8.0_191                                   *
 */

package frontend;

import backend.BmiCalculator;
import backend.BmiException;
import backend.Sex;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
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
        sexComboBox.getSelectionModel().select(Sex.UNKNOWN);
        bmiCalc.setSex(Sex.UNKNOWN);
        sexComboBox.valueProperty().addListener((observable, oldValue, newValue) -> {
            bmiCalc.setSex(newValue);
        });
        ageTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.isEmpty()) {
                bmiCalc.setAge(Integer.parseInt(newValue));
            }
        });
        weightTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.isEmpty()) {
                bmiCalc.setWeight(Integer.parseInt(newValue));
            }
        });
        sizeTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.isEmpty()) {
                bmiCalc.setSize(Integer.parseInt(newValue));
            }
        });
    }

    public void calculate() {
        try {
            resultLabel.setText(String.valueOf(Math.round(bmiCalc.getBmi())));
            categoryLabel.setText(String.valueOf(bmiCalc.getCategory()));
        } catch (BmiException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.getLocalizedMessage());
            alert.showAndWait();
        }
    }
}
