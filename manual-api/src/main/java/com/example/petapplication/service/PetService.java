package com.example.petapplication.service;

import com.example.petapplication.entity.Pet;
import java.util.List;

public interface PetService {
    Pet savePet (Pet pet);
    List <Pet> fetchAllPets();
    Pet fetchPetById(Long petId);
    Pet updatePet(Pet pet, Long petId);
    void deletePetById(Long petId);


}
