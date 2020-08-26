package com.petstore.petstoreapp.service.pet.petService;

import com.petstore.petstoreapp.models.Pet;

import java.util.List;

public interface PetService {

    Pet savePet(Pet pet);

    Pet findPetById(Integer id);

    List<Pet> findAllPet();

    Pet updatePet(Pet pet);

    void deletePet(Integer id);
}
