package com.example.veterinaria.Entitys;

public class Owner {

    private int id;
    private String name;
    private String surname;
    private long number;

    public Owner(String name, String surname, long number) {
        this.name = name;
        this.surname = surname;
        this.number = number;
    }
}
