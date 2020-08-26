package com.petstore.petstoreapp.service.pet.PetService;

import com.petstore.petstoreapp.models.Pet;
import com.petstore.petstoreapp.repository.PetRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public  class PetServiceImpl implements PetService {

    @Autowired
    PetRepo petRepo;

    @Override
    public Pet savePet(Pet pet) {
        return petRepo.save(pet);
    }

    @Override
    public Pet findPetById(Integer id) {
        return petRepo.findById(id).orElse(null);
    }

    @Override
    public List<Pet> findAllPet() {
        return petRepo.findAll();
    }

    @Override
    public Pet updatePet(Pet pet) {
        return petRepo.save(pet);
    }

    @Override
    public void deletePet(Integer id) {

        petRepo.deleteById(id);

    }
}
