package com.example.petapplication.dto;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;
public class PetDto {
    Long Id;

    @NotBlank(message = "Name cannot be empty")
    @Size(min = 2, max = 20, message = "Name must be between 2 and 20 characters")
    @Pattern(regexp = "^[a-zA-Z]*$", message = "Name must only contain letters")
    String name;

    @NotBlank(message = "Name cannot be empty")
    @Size(min = 2, max = 20, message = "Name must be between 2 and 20 characters")
    @Pattern(regexp = "^[a-zA-Z]*$", message = "Name must only contain letters")
    String type;

    @NotBlank(message = "Name cannot be empty")
    @Size(min = 2, max = 20, message = "Name must be between 2 and 20 characters")
    @Pattern(regexp = "^[a-zA-Z]*$", message = "Name must only contain letters")
    String race;

    @NotBlank(message = "Name cannot be empty")
    @Size(min = 2, max = 20, message = "Name must be between 2 and 20 characters")
    @Pattern(regexp = "^[a-zA-Z]*$", message = "Name must only contain letters")
    String owner;

    @Min(value = 0, message = "Age cannot be negative")
    @Max(value = 300, message = "Age cannot exceed 30")
    int age;

    @Min(value = 0, message = "Age cannot be negative")
    @Max(value = 150, message = "Age cannot exceed 150")
    int ownerAge;

    public PetDto() {
        this.Id = Id;
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

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }
}
