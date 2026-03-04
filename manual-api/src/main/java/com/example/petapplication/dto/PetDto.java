package com.example.petapplication.dto;

public class PetDto {
    String name;
    String type;
    String race;
    String owner;
    int age;
    int ownerAge;

    public PetDto() {
        this.name = name;
        this.type = type;
        this.race = race;
        this.owner = owner;
        this.age = age;
        this.ownerAge = ownerAge;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getOwnerAge() {
        return ownerAge;
    }

    public void setOwnerAge(int ownerAge) {
        this.ownerAge = ownerAge;
    }
}
