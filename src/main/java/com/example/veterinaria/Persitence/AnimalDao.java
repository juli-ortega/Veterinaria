package com.example.veterinaria.Persitence;

import com.example.veterinaria.DatabaseConnector;
import com.example.veterinaria.Entitys.Animal;
import com.example.veterinaria.Entitys.Owner;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AnimalDao {
    private DatabaseConnector databaseConnector;

    public AnimalDao() {
        this.databaseConnector = new DatabaseConnector();
    }

    public boolean register(Animal animal, Owner owner) throws Exception {
        Connection connection = null;
        PreparedStatement sentenceOwner = null;
        PreparedStatement sentenceAnimal = null;

        try {
            connection = DatabaseConnector.getConnection();
            String SQLOwner = "INSERT INTO owner (name, surname, number) VALUES (?, ?, ?)";
            sentenceOwner = connection.prepareStatement(SQLOwner, Statement.RETURN_GENERATED_KEYS);
            sentenceOwner.setString(1, owner.getName());
            sentenceOwner.setString(2, owner.getSurname());
            sentenceOwner.setLong(3, owner.getNumber());
            sentenceOwner.executeUpdate();

            ResultSet generatedKeys = sentenceOwner.getGeneratedKeys();
            int ownerId = -1;
            if (generatedKeys.next()) {
                ownerId = generatedKeys.getInt(1);
            } else {
                throw new SQLException("No se pudo obtener el ID del propietario insertado.");
            }

            // Insertar el animal utilizando el ID del propietario
            String SQLAnimal = "INSERT INTO animal (name, race, age, appearance, titleHistorical, historical, allergic, owner_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            sentenceAnimal = connection.prepareStatement(SQLAnimal);
            sentenceAnimal.setString(1, animal.getName());
            sentenceAnimal.setString(2, animal.getRace());
            sentenceAnimal.setInt(3, animal.getAge());
            sentenceAnimal.setString(4, animal.getAppearance());
            sentenceAnimal.setString(5, animal.getTitleHistorical());
            sentenceAnimal.setString(6, animal.getHistorical());
            sentenceAnimal.setBoolean(7, animal.isAllergic());
            sentenceAnimal.setInt(8, ownerId);
            sentenceAnimal.executeUpdate();

            return true;
        } catch (Exception e) {
            System.out.println("No se pudo cargar el animal a la base de datos");
            e.printStackTrace();
            return false;
        } finally {
            // Cerrar recursos
            if (sentenceOwner != null) {
                sentenceOwner.close();
            }
            if (sentenceAnimal != null) {
                sentenceAnimal.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    };
    public List<Animal> listAnimals(String search) throws SQLException {
        Connection connection = null;
        PreparedStatement sentence = null;
        String surname = search.toLowerCase();
        surname = surname.replaceAll("[áéíóú]", "aeiou");
        surname = surname.substring(0, 1).toUpperCase() + surname.substring(1);
        List<Animal> animals = new ArrayList<>();

        try {
            connection = DatabaseConnector.getConnection();
            String SQL = "SELECT a.* FROM veterinaria.owner o " +
                    "JOIN veterinaria.animal a ON o.id = a.owner_id " +
                    "WHERE o.surname = ?";
            sentence = connection.prepareStatement(SQL);
            sentence.setString(1, surname);

            ResultSet results = sentence.executeQuery();

            while (results.next()) {
                Animal animal = new Animal();
                animal.setName(results.getString("name"));
                animal.setRace(results.getString("race"));
                animal.setAge(results.getInt("age"));
                animal.setTitleHistorical(results.getString("titleHistorical"));
                animal.setHistorical(results.getString("historical"));
                animal.setAllergic(results.getBoolean("allergic"));
                animals.add(animal);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener animales de la base de datos: " + e.getMessage());
            throw e;
        } finally {
            if (sentence != null) {
                sentence.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

        return animals;
    }




}
