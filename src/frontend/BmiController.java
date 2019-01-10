package frontend;

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        sexComboBox.setItems(FXCollections.observableList(Arrays.asList(Sex.values())));
    }

    void calculate(){

    }
}
