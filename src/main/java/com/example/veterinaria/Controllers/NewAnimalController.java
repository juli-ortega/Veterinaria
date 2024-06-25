package com.example.veterinaria.Controllers;

import com.example.veterinaria.Entitys.Animal;
import com.example.veterinaria.Entitys.Owner;
import com.example.veterinaria.Persitence.AnimalDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.StageStyle;

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

    private AnimalDao animalDao;


    public void listAlergic(Event event) {
        ObservableList<String> cmsiono = FXCollections.observableArrayList("Si", "No");
        fillCombo(cbxAllergic, cmsiono);
    }

    public void save(ActionEvent actionEvent) throws Exception {
        this.animalDao = new AnimalDao();
        Owner owner = new Owner();
        owner.setName(txtname.getText());
        String surname = txtSurname.getText().toLowerCase();
        surname = surname.replaceAll("[áéíóú]", "aeiou");
        surname = surname.substring(0, 1).toUpperCase() + surname.substring(1);
        owner.setSurname(surname);
        owner.setNumber(Long.parseLong(txtnumber.getText()));

        Animal animal = new Animal();
        animal.setName(txtName.getText());
        animal.setRace(txtRace.getText());
        animal.setAge(Integer.parseInt(txtAge.getText()));
        animal.setAppearance(txtAppearance.getText());
        animal.setTitleHistorical(txtTitleHistorical.getText());
        animal.setHistorical(txtHistorical.getText());
        String selectedValue = (String) cbxAllergic.getValue();
        if (selectedValue != null && selectedValue.equalsIgnoreCase("Si")) {
            animal.setAllergic(true);
        } else {
            animal.setAllergic(false);
        }

        animal.setOwner(owner);

        boolean ans = this.animalDao.register(animal,owner);
        if (ans == true){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Exito");
            alert.setHeaderText(null);
            alert.setContentText("Se ha guardado correctamente");
            alert.initStyle(StageStyle.UTILITY);
            alert.showAndWait();
            cleanFields();

        }else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Ha habido un error a la hora de guardar");
            alert.initStyle(StageStyle.UTILITY);
            alert.showAndWait();

        }

    }

    public void cleanFields() {
        cbxAllergic.setValue("Seleccione");
        txtName.setText("");
        txtRace.setText("");
        txtAge.setText("");
        txtAppearance.setText("");
        txtTitleHistorical.setText("");
        txtHistorical.setText("");
        txtSurname.setText("");
        txtnumber.setText("");
        txtname.setText("");
    }
}
