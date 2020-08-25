package com.petstore.petstoreapp.repository;

import com.petstore.petstoreapp.models.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Id;

public interface PetRepo extends JpaRepository<Pet, Id> {


}
