package com.example.veterinaria.Persitence;

import com.example.veterinaria.DatabaseConnector;
import com.example.veterinaria.Entitys.Animal;
import com.example.veterinaria.Entitys.Owner;

import java.sql.*;

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
            // Insertar el propietario
            String SQLOwner = "INSERT INTO owner (name, surname, number) VALUES (?, ?, ?)";
            sentenceOwner = connection.prepareStatement(SQLOwner, Statement.RETURN_GENERATED_KEYS);
            sentenceOwner.setString(1, owner.getName());
            sentenceOwner.setString(2, owner.getSurname());
            sentenceOwner.setLong(3, owner.getNumber());
            sentenceOwner.executeUpdate();

            // Obtener el ID del propietario insertado
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
    }

}
