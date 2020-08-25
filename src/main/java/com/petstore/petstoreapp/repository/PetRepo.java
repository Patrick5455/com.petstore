package com.petstore.petstoreapp.repository;

import com.petstore.petstoreapp.models.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;

@Repository
public interface PetRepo extends JpaRepository<Pet, Id> {


}
