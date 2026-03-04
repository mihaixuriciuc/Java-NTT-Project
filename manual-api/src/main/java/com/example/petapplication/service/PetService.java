package com.example.petapplication.service;

import com.example.petapplication.dto.PetDto;
import com.example.petapplication.dto.PetUpdateDto;
import com.example.petapplication.entity.Pet;
import java.util.List;

public interface PetService {
    Pet savePet (PetDto petDto);
    List <PetDto> fetchAllPets();
    PetDto fetchPetById(Long petId);
    PetDto updatePet(PetUpdateDto petUpdate, Long petId);
    void deletePetById(Long petId);


}
