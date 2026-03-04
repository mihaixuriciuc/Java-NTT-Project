package com.example.petapplication.dto;

public class PetUpdateDto {
    String name;
    String owner;
    int ownerAge;

    public PetUpdateDto() {
        this.name = name;
        this.owner = owner;
        this.ownerAge = ownerAge;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }


    public int getOwnerAge() {
        return ownerAge;
    }

    public void setOwnerAge(int ownerAge) {
        this.ownerAge = ownerAge;
    }
}
