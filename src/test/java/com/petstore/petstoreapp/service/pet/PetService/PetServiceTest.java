package com.petstore.petstoreapp.service.pet.PetService;

import com.petstore.petstoreapp.models.Pet;
import com.petstore.petstoreapp.repository.PetRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

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
    }

    @Test
    void findAllPet() {
    }

    @Test
    void updatePet() {
    }

    @Test
    void deletePet() {
    }
}