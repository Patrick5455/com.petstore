package com.petstore.petstoreapp.repository;

import com.petstore.petstoreapp.models.Pet;
import com.petstore.petstoreapp.models.Store;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.logging.Logger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest // this annotation marks the class as a test class, it also provides the beans of the container from the main application available during test
@Sql("classpath:db/insert-store.sql")
class StoreRepoTest {

    Logger log = Logger.getLogger(getClass().getName());

    @Autowired
    private StoreRepo storeRepo;

    @BeforeEach
    void setUp() {

       Store store = storeRepo.findById(2).orElse(null);
       assertThat(store).isNotNull();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void whenStoreIsRetrieved_thenRetrievedStoredPet(){

        //create pets
        Pet pet1 = new Pet();

        // add pets to Store


    }



}