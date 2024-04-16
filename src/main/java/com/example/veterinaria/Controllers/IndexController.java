package com.example.veterinaria.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import static com.example.veterinaria.HelloApplication.closeWindows;
import static com.example.veterinaria.HelloApplication.currentStage;

public class IndexController {
    public void callNewAnimal(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/veterinaria/NewAnimal.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            Stage newStage = new Stage();
            newStage.setScene(scene);
            newStage.show();
            closeWindows(currentStage);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void callSearchAnimal(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/veterinaria/SearchAnimal.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            Stage newStage = new Stage();
            newStage.setScene(scene);
            newStage.show();
            closeWindows(currentStage);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void callAssginShifts(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/veterinaria/AssignShifts.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            Stage newStage = new Stage();
            newStage.setScene(scene);
            newStage.show();
            closeWindows(currentStage);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void callViewShifts(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/veterinaria/ViewShifts.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            Stage newStage = new Stage();
            newStage.setScene(scene);
            newStage.show();
            closeWindows(currentStage);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}