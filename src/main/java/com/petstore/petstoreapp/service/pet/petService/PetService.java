package com.petstore.petstoreapp.service.pet.petService;

import com.petstore.petstoreapp.models.Pet;

import java.util.List;
import java.util.Optional;

public interface PetService {

    Pet savePet(Pet pet);

    // JpRepo.findById returns an Optional object
    Optional<Pet> findPetById(Integer id);

    List<Pet> findAllPet();

    Pet updatePet(Pet pet);

    void deletePet(Integer id);
}
