package com.example.petapplication.controller;
import com.example.petapplication.dto.PetDto;
import com.example.petapplication.dto.PetUpdateDto;
import com.example.petapplication.entity.Pet;
import com.example.petapplication.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PetController {
    @Autowired
    private PetService petService;


    @PostMapping("/pets")
    public Pet postPet(@RequestBody PetDto petDto){
        return petService.savePet(petDto);

    }

    @GetMapping("/pets")
    public List <PetDto> getPetList(){
        return petService.fetchAllPets();
    }
    @GetMapping("/pets/{petId}")
    public PetDto getIndvivdualPet(@PathVariable Long petId){
        return petService.fetchPetById(petId);
    }

    @PutMapping("/pets/{petId}")
    public void updatePet(@RequestBody PetUpdateDto petUpdateDto, @PathVariable Long petId){
        petService.updatePet(petUpdateDto,petId);
    }

    @DeleteMapping ("/pets/{petId}")
    public void deletePet(@PathVariable Long petId){
        petService.deletePetById(petId);
    }

}