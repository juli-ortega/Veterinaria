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
    @OneToOne
    private Owner owner;

    public Animal() {
    }

    public Animal(int id, String name, String race, int age, String appearance, String titleHistorical, String historical, boolean allergic, Owner owner) {
        this.id = id;
        this.name = name;
        this.race = race;
        this.age = age;
        this.appearance = appearance;
        this.titleHistorical = titleHistorical;
        this.historical = historical;
        this.allergic = allergic;
        this.owner = owner;
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

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAppearance() {
        return appearance;
    }

    public void setAppearance(String appearance) {
        this.appearance = appearance;
    }

    public String getTitleHistorical() {
        return titleHistorical;
    }

    public void setTitleHistorical(String titleHistorical) {
        this.titleHistorical = titleHistorical;
    }

    public String getHistorical() {
        return historical;
    }

    public void setHistorical(String historical) {
        this.historical = historical;
    }

    public boolean isAllergic() {
        return allergic;
    }

    public void setAllergic(boolean allergic) {
        this.allergic = allergic;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
