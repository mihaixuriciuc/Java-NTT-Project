package com.example.manual;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class PetService {

   public List<Pets> processPets(String type, String sort, String order) {
       List<Pets> myPets = generatePetInventory();

       List<Pets> filteredPets = new ArrayList<>();


       for (Pets pet : myPets) {
           if (type == null || pet.getType().equalsIgnoreCase(type)) {
               filteredPets.add(pet);
           }
       }
       List<Pets> finalpets = sortAlphabetticaly(sort, filteredPets);

       if (order.equalsIgnoreCase("desc")) {
           Collections.reverse(finalpets);
       }


       return finalpets;
   }

       private List<Pets> generatePetInventory() {
           List<Pets> list = new ArrayList<>();
           list.add(new Pets("Bobby", "Dog", "Marian Valeriu", "Pitbull", 6, 28));
           list.add(new Pets("Mittens", "Cat", "Alice", "Tabby", 2, 24));
           list.add(new Pets("Goldie", "Fish", "Bob", "Goldfish", 1, 30));
           list.add(new Pets("Rex", "Dog", "Charlie", "German Shepherd", 5, 45));
           list.add(new Pets("Luna", "Cat", "Diana", "Siamese", 3, 22));
           list.add(new Pets("Pip", "Bird", "Edward", "Parakeet", 1, 19));
           list.add(new Pets("Shadow", "Dog", "Fiona", "Labrador", 8, 50));
           list.add(new Pets("Smokey", "Cat", "George", "Persian", 4, 35));
           list.add(new Pets("Bubbles", "Fish", "Hannah", "Beta", 1, 12));
           list.add(new Pets("Cooper", "Dog", "Ian", "Beagle", 2, 27));
           list.add(new Pets("Bella", "Dog", "Julia", "Poodle", 7, 33));
           list.add(new Pets("Oliver", "Cat", "Kevin", "Maine Coon", 6, 40));
           list.add(new Pets("Zoe", "Dog", "Laura", "Chihuahua", 10, 65));
           list.add(new Pets("Leo", "Cat", "Mike", "Bengal", 2, 29));
           list.add(new Pets("Coco", "Bird", "Nina", "Cockatiel", 4, 21));
           list.add(new Pets("Rocky", "Dog", "Oscar", "Boxer", 3, 31));
           list.add(new Pets("Molly", "Dog", "Paula", "Golden Retriever", 5, 26));
           list.add(new Pets("Simba", "Cat", "Quinn", "Ragdoll", 1, 23));
           list.add(new Pets("Toby", "Dog", "Riley", "Dachshund", 9, 55));
           list.add(new Pets("Lucy", "Cat", "Steve", "Sphynx", 3, 38));
           list.add(new Pets("Nemo", "Fish", "Tina", "Clownfish", 1, 10));
           list.add(new Pets("Daisy", "Dog", "Umar", "Pug", 4, 32));
           list.add(new Pets("Felix", "Cat", "Vicky", "Black Cat", 7, 44));
           list.add(new Pets("Buster", "Dog", "Will", "Bulldog", 6, 36));
           list.add(new Pets("Skye", "Bird", "Xena", "Macaw", 12, 25));
           return list;
       }

       private List<Pets> sortAlphabetticaly(String sortValue, List<Pets> pets) {

           int n = pets.size();

           if (sortValue.equalsIgnoreCase("name")) {
               for (int i = 0; i < n; i++) {
                   for (int j = i + 1; j < n; j++) {
                       String nameI = pets.get(i).getName();
                       String nameJ = pets.get(j).getName();
                       if (nameI.compareTo(nameJ) > 0) {
                           // swapping
                           Pets temp = pets.get(i);
                           pets.set(i, pets.get(j));
                           pets.set(j, temp);
                       }
                   }
               }
           } else if (sortValue.equalsIgnoreCase("type")) {
               for (int i = 0; i < n; i++) {
                   for (int j = i + 1; j < n; j++) {
                       String nameI = pets.get(i).getType();
                       String nameJ = pets.get(j).getType();
                       if (nameI.compareTo(nameJ) > 0) {
                           // swapping
                           Pets temp = pets.get(i);
                           pets.set(i, pets.get(j));
                           pets.set(j, temp);
                       }
                   }
               }
           } else if (sortValue.equalsIgnoreCase("race")) {
               for (int i = 0; i < n; i++) {
                   for (int j = i + 1; j < n; j++) {
                       String nameI = pets.get(i).getRace();
                       String nameJ = pets.get(j).getRace();
                       if (nameI.compareTo(nameJ) > 0) {
                           // swapping
                           Pets temp = pets.get(i);
                           pets.set(i, pets.get(j));
                           pets.set(j, temp);
                       }
                   }
               }
           } else if (sortValue.equalsIgnoreCase("owner")) {
               for (int i = 0; i < n; i++) {
                   for (int j = i + 1; j < n; j++) {
                       String nameI = pets.get(i).getOwner();
                       String nameJ = pets.get(j).getOwner();
                       if (nameI.compareTo(nameJ) > 0) {
                           // swapping
                           Pets temp = pets.get(i);
                           pets.set(i, pets.get(j));
                           pets.set(j, temp);
                       }
                   }
               }
           } else if (sortValue.equalsIgnoreCase("age")) {
               for (int i = 0; i < n; i++) {
                   for (int j = i + 1; j < n; j++) {
                       int nameI = pets.get(i).getAge();
                       int nameJ = pets.get(j).getAge();
                       if (nameI > nameJ) {
                           // swapping
                           Pets temp = pets.get(i);
                           pets.set(i, pets.get(j));
                           pets.set(j, temp);
                       }
                   }
               }
           } else if (sortValue.equalsIgnoreCase("owner_age")) {
               for (int i = 0; i < n; i++) {
                   for (int j = i + 1; j < n; j++) {
                       int nameI = pets.get(i).getOwner_age();
                       int nameJ = pets.get(j).getOwner_age();
                       if (nameI > nameJ) {
                           // swapping
                           Pets temp = pets.get(i);
                           pets.set(i, pets.get(j));
                           pets.set(j, temp);
                       }
                   }
               }
           }

           return pets;
       }
   }


