package com.example.petapplication.dto;

import jakarta.validation.constraints.*;

public class PetUpdateDto {

    @NotBlank(message = "Name cannot be empty")
    @Size(min = 2, max = 20, message = "Name must be between 2 and 20 characters")
    @Pattern(regexp = "^[a-zA-Z]*$", message = "Name must only contain letters")
    String name;

    @NotBlank(message = "Name cannot be empty")
    @Size(min = 2, max = 20, message = "Name must be between 2 and 20 characters")
    @Pattern(regexp = "^[a-zA-Z]*$", message = "Name must only contain letters")
    String owner;

    @Min(value = 0, message = "Age cannot be negative")
    @Max(value = 150, message = "Age cannot exceed 150")
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
