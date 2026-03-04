package com.example.petapplication.controller;
import com.example.petapplication.dto.PetDto;
import com.example.petapplication.dto.PetUpdateDto;
import com.example.petapplication.entity.Pet;
import com.example.petapplication.service.PetService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PetController {
    @Autowired
    private PetService petService;


    @PostMapping("/pets")
    public ResponseEntity<Pet> postPet(@Valid @RequestBody PetDto petDto){
        return new ResponseEntity<>(petService.savePet(petDto),HttpStatus.CREATED);

    }

    @GetMapping("/pets")
    public ResponseEntity<List<PetDto>> getPetList(){
        return new ResponseEntity<>(petService.fetchAllPets(),HttpStatus.OK);
    }

    @GetMapping("/pets/{petId}")
    public ResponseEntity<PetDto> getIndvivdualPet(@PathVariable Long petId){
        return new ResponseEntity<>(petService.fetchPetById(petId),HttpStatus.OK);
    }

    @PutMapping("/pets/{petId}")
    public ResponseEntity<PetDto> updatePet(@Valid @RequestBody PetUpdateDto petUpdateDto, @PathVariable Long petId){
        PetDto pet = petService.updatePet(petUpdateDto,petId);

        return new ResponseEntity<>(pet, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePet(@PathVariable Long id) {
        petService.deletePetById(id);
        return ResponseEntity.noContent().build();
    }

}