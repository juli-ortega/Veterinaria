package com.example.veterinaria;

import javafx.application.Application;
import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HelloApplication extends Application {

    public static Stage currentStage;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Index.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 400);
        stage.setTitle("Veterinaria");
        stage.setScene(scene);
        stage.show();
        currentStage = stage;

    }

    public static void main(String[] args) {
        launch();
    }

    public static void closeWindows(Stage stage) {
        stage.close();
    }

    public static void fillCombo(ComboBox<String> listCm, ObservableList<String> infoCombo) {
        listCm.setItems(infoCombo);
    }
    public static void connectorDB(String table){

        try {
            Connection connection = DatabaseConnector.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM " + table);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                // Procesa los resultados
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

