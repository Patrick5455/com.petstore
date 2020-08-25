package com.petstore.petstoreapp.repository;

import com.petstore.petstoreapp.models.Pet;
import com.petstore.petstoreapp.models.PetSex;
import com.petstore.petstoreapp.models.PetTypes;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.logging.Logger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@Slf4j // lombok annotaion for logging
class PetRepoTest {

    Logger log = Logger.getLogger(getClass().getName());

    @Autowired
    private PetRepo petRepo;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    void createPetObjectThenSaveToDatabase(){

        Pet pet = new Pet();

        pet.setAge(5);
        pet.setName("Lucky");
        pet.setSex(PetSex.MALE);
        pet.setTypes(PetTypes.DOG);
        pet.setBreed("Bull Dog");
        pet.setBirthdate(new Date());

        // Log records
        log.info("Created Pet Object ---> " + pet);
        assertThat(pet.getId()).isNull();
    }
}