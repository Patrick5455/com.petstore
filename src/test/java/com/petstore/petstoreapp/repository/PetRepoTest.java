package com.petstore.petstoreapp.repository;

import com.petstore.petstoreapp.models.Pet;
import com.petstore.petstoreapp.models.PetSex;
import com.petstore.petstoreapp.models.PetTypes;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Sql(scripts = {"classpath:db/insert-pet.sql"})
//@Slf4j // lombok annotaion for loggin
class PetRepoTest {

    Logger log = Logger.getLogger(getClass().getName());

    @Autowired
    private PetRepo petRepo;

    Pet testPetData;

    @BeforeEach
    void setUp() {

        testPetData = petRepo.findById(200).orElse(null);
        assertThat(testPetData).isNotNull();
        log.info("Test pet data retrieved first database -->"+testPetData);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void createPetObject_thenSaveToDatabase(){

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

        //save pet object to the database
        pet = petRepo.save(pet);
        log.info("After saving pet object ----> "+ pet);
        assertThat(pet.getId()).isNotNull();

    }

    @Test
    void whenFindAllPetsIsCalled_thenRetrievePetListTest(){

        List<Pet> allPets = petRepo.findAll();
        assertThat(allPets.size()).isEqualTo(8);
        log.info("All pets retrived from the database -->"+ allPets);
    }


    @Test
    void whenPetDetailsIsUpdated_thenDatabaseIsUpdated(){

        assertThat(testPetData.getName()).isEqualTo("bobby");
        testPetData.setName("Jira");
        assertThat(testPetData.getName()).isEqualTo("jira");
    }


    @Test
    void  whenDeleteIsCalled_thenDeletePetDataTest(){

        List<Pet> allPets = petRepo.findAll();
        assertThat(allPets).isNotNull();
        assertThat(allPets.size()).isEqualTo(8);

        Pet savedPet = petRepo.findById(300).orElse(null);
        assertThat(savedPet).isNotNull();
        petRepo.deleteById(300);

        Pet deletedPet = petRepo.findById(300).orElse(null);
        assertThat(deletedPet).isNull();

        allPets = petRepo.findAll();
        assertThat(allPets).isNotNull();
        assertThat(allPets.size()).isEqualTo(7);
    }


}