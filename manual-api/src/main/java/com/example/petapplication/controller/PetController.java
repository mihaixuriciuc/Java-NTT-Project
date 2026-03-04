package com.example.petapplication.controller;
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
    public Pet postPet(@RequestBody Pet pet){
        return petService.savePet(pet);

    }

    @GetMapping("/pets")
    public List <Pet> getPetList(){
        return petService.fetchAllPets();
    }
    @GetMapping("/pets/{petId}")
    public Pet getIndvivdualPet(@PathVariable Long petId){
        return petService.fetchPetById(petId);
    }

    @PutMapping("/pets/{petId}")
    public void updatePet(@RequestBody Pet pet, @PathVariable Long petId){
        petService.updatePet(pet,petId);
    }

    @DeleteMapping ("/pets/{petId}")
    public void deletePet(@PathVariable Long petId){
        petService.deletePetById(petId);
    }

}