package com.example.veterinaria.Entitys;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String name;
    private String surname;
    private long number;

    public Owner() {
    }

    public Owner(int id, String name, String surname, long number) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }
}
