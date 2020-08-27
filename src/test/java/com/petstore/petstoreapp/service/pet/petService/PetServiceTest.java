package com.petstore.petstoreapp.service.pet.petService;

import com.petstore.petstoreapp.models.Pet;
import com.petstore.petstoreapp.repository.PetRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

// Mock Test no need for SpringbootTest annotation because Mock creates mock object independent of the application context
class PetServiceTest {

    @Mock
    PetRepo petRepo;


    @InjectMocks
    PetService petService;

    Pet testPet;

    @BeforeEach
    void setUp() {

        petService = new PetServiceImpl();
        testPet = new Pet();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void savePet() {

        when(petService.savePet(testPet)).thenReturn(testPet);
        petService.savePet(testPet);
        verify(petRepo, times(1)).save(testPet);
    }

    @Test
    void findPetById() {

        testPet.setId(1);

        //PetService petService =  Mockito.mock(PetService.class);

        when(petService.findPetById(testPet.getId())).thenReturn(Optional.of(testPet));
        petService.findPetById(testPet.getId());
        verify(petRepo, times(1)).findById(testPet.getId());

    }

    @Test
    void findAllPet() {

        List<Pet> petList = new ArrayList<>();
        when(petService.findAllPet()).thenReturn(petList);
        petService.findAllPet();

        verify(petRepo, times(1)).findAll();

    }

    @Test
    void updatePet() {

        when(petService.updatePet(testPet)).thenReturn(testPet);
        petService.updatePet(testPet);
        verify(petRepo, times(1)).save(testPet);

    }

    @Test
    void deletePet() {

        doNothing().when(petRepo).delete(testPet);
        petService.deletePet(testPet.getId());
        verify(petRepo, times(1)).deleteById(testPet.getId());
    }
}