package com.example.veterinaria.Entitys;
import jakarta.persistence.*;

@Entity
@Table
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String name;
    private String race;
    private int age;
    private String appearance;
    private String titleHistorical;
    private String historical;
    private boolean allergic;

    public Animal(String name, String race, int age, String appearance,
                  String titleHistorical, String historical, boolean allergic) {
        this.name = name;
        this.race = race;
        this.age = age;
        this.appearance = appearance;
        this.titleHistorical = titleHistorical;
        this.historical = historical;
        this.allergic = allergic;
    }
}
