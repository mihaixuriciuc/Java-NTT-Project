package com.example.petapplication.mapper;

import com.example.petapplication.dto.PetDto;
import com.example.petapplication.dto.PetUpdateDto;
import com.example.petapplication.entity.Pet;
import org.springframework.stereotype.Component;

@Component
public class PetMapper {

    public Pet convertToEntity(PetDto petDto){
        Pet pet = new Pet();
        pet.setPetId(petDto.getId());
        pet.setName(petDto.getName());
        pet.setType(petDto.getType());
        pet.setAge(petDto.getAge());
        pet.setRace(petDto.getRace());
        pet.setOwner(petDto.getOwner());
        pet.setOwnerAge(petDto.getOwnerAge());

        return pet;

    }


    public PetDto convertToDto(Pet pet) {

        PetDto petDto = new PetDto();
        petDto.setId(pet.getPetId());
        petDto.setName(pet.getName());
        petDto.setType(pet.getType());
        petDto.setAge(pet.getAge());
        petDto.setRace(pet.getRace());
        petDto.setOwner(pet.getOwner());
        petDto.setOwnerAge(pet.getOwnerAge());
        return petDto;
    }

    public PetUpdateDto updatePet(Pet pet){
        PetUpdateDto petUpdateDto = new PetUpdateDto();
        petUpdateDto.setName(pet.getName());
        petUpdateDto.setOwner(pet.getOwner());
        petUpdateDto.setOwnerAge(pet.getOwnerAge());
        return petUpdateDto;
    }

}
