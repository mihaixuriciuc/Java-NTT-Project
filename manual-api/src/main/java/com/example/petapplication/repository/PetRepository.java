package com.example.petapplication.repository;

import com.example.petapplication.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;



public interface PetRepository extends JpaRepository<Pet,Long>  {


}
