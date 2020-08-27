package com.petstore.petstoreapp.service.pet.petService;

import com.petstore.petstoreapp.models.Pet;
import com.petstore.petstoreapp.repository.PetRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public  class PetServiceImpl implements PetService {

    @Autowired
    PetRepo petRepo;

    @Override
    public Pet savePet(Pet pet) {
        return petRepo.save(pet);
    }

    @Override
    public Optional<Pet> findPetById(Integer id) {

        return petRepo.findById(id);
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
