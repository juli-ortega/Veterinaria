package com.example.veterinaria.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import static com.example.veterinaria.HelloApplication.fillCombo;

public class NewAnimalController {

    public ComboBox cbxAllergic;
    public TextField txtName;
    public TextField txtRace;
    public TextField txtAge;
    public TextField txtAppearance;
    public TextField txtTitleHistorical;
    public TextArea txtHistorical;
    public TextField txtSurname;
    public TextField txtnumber;
    public TextField txtname;


    public void listAlergic(Event event) {
        ObservableList<String> cmsiono = FXCollections.observableArrayList("Si", "No");
        fillCombo(cbxAllergic, cmsiono);
    }
}
