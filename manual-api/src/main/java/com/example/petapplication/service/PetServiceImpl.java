package com.example.petapplication.service;

import com.example.petapplication.dto.PetDto;
import com.example.petapplication.dto.PetUpdateDto;
import com.example.petapplication.entity.Pet;

import com.example.petapplication.error.PetNotFoundException;
import com.example.petapplication.repository.PetRepository;
import com.example.petapplication.mapper.PetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class PetServiceImpl implements PetService{
    @Autowired
    private PetRepository petRepository;
    @Autowired
    private PetMapper petMapper;

    @Override
    public Pet savePet(PetDto petDto){
        return petRepository.save(petMapper.convertToEntity(petDto));
    }

    @Override
    public List <PetDto> fetchAllPets(){
        List <Pet> petsToFind =  petRepository.findAll();
        if (petsToFind.isEmpty()){
            throw new PetNotFoundException("The database is empty."); // this error
        }
        List <PetDto> finalPetsDto = new ArrayList<>();
        for (Pet pet : petsToFind){
            PetDto updatedPet = petMapper.convertToDto(pet);
            finalPetsDto.add(updatedPet);
        }
        return finalPetsDto;
    }

    @Override
    public PetDto fetchPetById(Long petId){
        Pet pet = petRepository.findById(petId).orElse(null);
        if(!petRepository.existsById(petId)){
            throw new PetNotFoundException("Pet Id (" + petId + ") not found."); // this error
        }else {
            return petMapper.convertToDto(pet);
        }
    };

    @Override
    public PetDto updatePet(PetUpdateDto petUpdate, Long petId){
        Pet petObject = petRepository.findById(petId).orElse(null);
        if(!petRepository.existsById(petId)){
            throw new PetNotFoundException("Pet Id (" + petId + ") not found to update."); // this error
        }
        if(Objects.nonNull(petUpdate.getName()) && !"".equalsIgnoreCase(petUpdate.getName())){
            petObject.setName(petUpdate.getName());
        }
        if(Objects.nonNull(petUpdate.getOwner()) && !"".equalsIgnoreCase(petUpdate.getOwner())){
            petObject.setOwner(petUpdate.getOwner());
        }
        if(petUpdate.getOwnerAge() != 0){
            petObject.setOwnerAge(petUpdate.getOwnerAge());
        }
        Pet finalPet = petRepository.save(petObject);

        return petMapper.convertToDto(finalPet);
    }
    @Override
    public void deletePetById(Long petId){
        if(!petRepository.existsById(petId)){
            throw new PetNotFoundException("Pet Id (" + petId + ") not found to delete."); // this error
        }else {
            petRepository.deleteById(petId);
        }
    }
}




/*Outdated logic, but i cant give up on it yet
public class PetServiceImpl {

   public List<Pet> processPet(String type, String sort, String order) {
       List<Pet> myPet = generatePetInventory();

       List<Pet> filteredPet = new ArrayList<>();


       for (Pet pet : myPet) {
           if (type == null || pet.getType().equalsIgnoreCase(type)) {
               filteredPet.add(pet);
           }
       }
       List<Pet> finalPet = sortAlphabetticaly(sort, filteredPet);

       if (order.equalsIgnoreCase("desc")) {
           Collections.reverse(finalPet);
       }


       return finalPet;
   }

       private List<Pet> generatePetInventory() {
           List<Pet> list = new ArrayList<>();
           list.add(new Pet("Bobby", "Dog", "Marian Valeriu", "Pitbull", 6, 28));
           list.add(new Pet("Mittens", "Cat", "Alice", "Tabby", 2, 24));
           list.add(new Pet("Goldie", "Fish", "Bob", "Goldfish", 1, 30));
           list.add(new Pet("Rex", "Dog", "Charlie", "German Shepherd", 5, 45));
           list.add(new Pet("Luna", "Cat", "Diana", "Siamese", 3, 22));
           list.add(new Pet("Pip", "Bird", "Edward", "Parakeet", 1, 19));
           list.add(new Pet("Shadow", "Dog", "Fiona", "Labrador", 8, 50));
           list.add(new Pet("Smokey", "Cat", "George", "Persian", 4, 35));
           list.add(new Pet("Bubbles", "Fish", "Hannah", "Beta", 1, 12));
           list.add(new Pet("Cooper", "Dog", "Ian", "Beagle", 2, 27));
           list.add(new Pet("Bella", "Dog", "Julia", "Poodle", 7, 33));
           list.add(new Pet("Oliver", "Cat", "Kevin", "Maine Coon", 6, 40));
           list.add(new Pet("Zoe", "Dog", "Laura", "Chihuahua", 10, 65));
           list.add(new Pet("Leo", "Cat", "Mike", "Bengal", 2, 29));
           list.add(new Pet("Coco", "Bird", "Nina", "Cockatiel", 4, 21));
           list.add(new Pet("Rocky", "Dog", "Oscar", "Boxer", 3, 31));
           list.add(new Pet("Molly", "Dog", "Paula", "Golden Retriever", 5, 26));
           list.add(new Pet("Simba", "Cat", "Quinn", "Ragdoll", 1, 23));
           list.add(new Pet("Toby", "Dog", "Riley", "Dachshund", 9, 55));
           list.add(new Pet("Lucy", "Cat", "Steve", "Sphynx", 3, 38));
           list.add(new Pet("Nemo", "Fish", "Tina", "Clownfish", 1, 10));
           list.add(new Pet("Daisy", "Dog", "Umar", "Pug", 4, 32));
           list.add(new Pet("Felix", "Cat", "Vicky", "Black Cat", 7, 44));
           list.add(new Pet("Buster", "Dog", "Will", "Bulldog", 6, 36));
           list.add(new Pet("Skye", "Bird", "Xena", "Macaw", 12, 25));
           return list;
       }

       private List<Pet> sortAlphabetticaly(String sortValue, List<Pet> Pet) {

           int n = Pet.size();

           if (sortValue.equalsIgnoreCase("name")) {
               for (int i = 0; i < n; i++) {
                   for (int j = i + 1; j < n; j++) {
                       String nameI = Pet.get(i).getName();
                       String nameJ = Pet.get(j).getName();
                       if (nameI.compareTo(nameJ) > 0) {
                           // swapping
                           Pet temp = Pet.get(i);
                           Pet.set(i, Pet.get(j));
                           Pet.set(j, temp);
                       }
                   }
               }
           } else if (sortValue.equalsIgnoreCase("type")) {
               for (int i = 0; i < n; i++) {
                   for (int j = i + 1; j < n; j++) {
                       String nameI = Pet.get(i).getType();
                       String nameJ = Pet.get(j).getType();
                       if (nameI.compareTo(nameJ) > 0) {
                           // swapping
                           Pet temp = Pet.get(i);
                           Pet.set(i, Pet.get(j));
                           Pet.set(j, temp);
                       }
                   }
               }
           } else if (sortValue.equalsIgnoreCase("race")) {
               for (int i = 0; i < n; i++) {
                   for (int j = i + 1; j < n; j++) {
                       String nameI = Pet.get(i).getRace();
                       String nameJ = Pet.get(j).getRace();
                       if (nameI.compareTo(nameJ) > 0) {
                           // swapping
                           Pet temp = Pet.get(i);
                           Pet.set(i, Pet.get(j));
                           Pet.set(j, temp);
                       }
                   }
               }
           } else if (sortValue.equalsIgnoreCase("owner")) {
               for (int i = 0; i < n; i++) {
                   for (int j = i + 1; j < n; j++) {
                       String nameI = Pet.get(i).getOwner();
                       String nameJ = Pet.get(j).getOwner();
                       if (nameI.compareTo(nameJ) > 0) {
                           // swapping
                           Pet temp = Pet.get(i);
                           Pet.set(i, Pet.get(j));
                           Pet.set(j, temp);
                       }
                   }
               }
           } else if (sortValue.equalsIgnoreCase("age")) {
               for (int i = 0; i < n; i++) {
                   for (int j = i + 1; j < n; j++) {
                       int nameI = Pet.get(i).getAge();
                       int nameJ = Pet.get(j).getAge();
                       if (nameI > nameJ) {
                           // swapping
                           Pet temp = Pet.get(i);
                           Pet.set(i, Pet.get(j));
                           Pet.set(j, temp);
                       }
                   }
               }
           } else if (sortValue.equalsIgnoreCase("owner_age")) {
               for (int i = 0; i < n; i++) {
                   for (int j = i + 1; j < n; j++) {
                       int nameI = Pet.get(i).getOwner_age();
                       int nameJ = Pet.get(j).getOwner_age();
                       if (nameI > nameJ) {
                           // swapping
                           Pet temp = Pet.get(i);
                           Pet.set(i, Pet.get(j));
                           Pet.set(j, temp);
                       }
                   }
               }
           }

           return Pet;
       }
   }
*/

