package com.example.petapplication.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;



@Entity
public class Pet{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long petId;
    private String name;
    private String type;
    private String owner;
    private String race;
    private int age;
    private int ownerAge;

    public Pet(){
    }

    public Pet(int ownerAge, int age, String race, String owner, String type, String name, Long petId) {
        this.ownerAge = ownerAge;
        this.age = age;
        this.race = race;
        this.owner = owner;
        this.type = type;
        this.name = name;
        this.petId = petId;
    }

    public Long getPetId() {
        return petId;
    }

    public void setPetId(Long petId) {
        this.petId = petId;
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

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
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

    public int getOwnerAge() {
        return ownerAge;
    }

    public void setOwnerAge(int ownerAge) {
        this.ownerAge = ownerAge;
    }


}




