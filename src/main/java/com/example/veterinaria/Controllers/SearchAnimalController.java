package com.example.veterinaria.Controllers;

import com.example.veterinaria.Persitence.AnimalDao;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class SearchAnimalController {

    public TextField txtSearchAnimal;

    public void searchAnimals() throws SQLException {
        AnimalDao animalDao = new AnimalDao();
        animalDao.listAnimals(String.valueOf(txtSearchAnimal));
    }

}
