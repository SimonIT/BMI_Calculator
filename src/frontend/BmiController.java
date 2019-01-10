package frontend;

import backend.BmiCalculator;
import backend.Sex;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class BmiController implements Initializable {

    @FXML
    ComboBox<Sex> sexComboBox;

    @FXML
    NumberField age;

    @FXML
    NumberField weight;

    @FXML
    NumberField size;

    BmiCalculator calculator = new BmiCalculator();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        sexComboBox.setItems(FXCollections.observableList(Arrays.asList(Sex.values())));
        age.textProperty().addListener((observable, oldValue, newValue) -> {
            if(!age.getText().isEmpty()) {
                calculator.setAge(Integer.parseInt(age.getText()));
            }
        });
        weight.textProperty().addListener((observable, oldValue, newValue) -> {
            if(!weight.getText().isEmpty()) {
                calculator.setWeight(Integer.parseInt(weight.getText()));
            }
        });
        size.textProperty().addListener((observable, oldValue, newValue) -> {
            if(!weight.getText().isEmpty()) {
                calculator.setSize(Integer.parseInt(weight.getText()));
            }
        });
    }

    void calculate() {

    }
}
