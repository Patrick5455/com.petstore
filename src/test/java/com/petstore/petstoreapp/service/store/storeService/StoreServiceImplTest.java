package com.petstore.petstoreapp.service.store.storeService;

import com.petstore.petstoreapp.models.Pet;
import com.petstore.petstoreapp.models.PetSex;
import com.petstore.petstoreapp.models.PetTypes;
import com.petstore.petstoreapp.models.Store;
import com.petstore.petstoreapp.repository.StoreRepo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.junit.jupiter.api.Test;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import static org.mockito.Mock.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest // we are adding this becuase we are doing a hard test for addPets
@Sql("classpath:db/insert-store.sql")
class StoreServiceImplTest {

    @Mock
    StoreRepo storeRepo;

    @Autowired
    StoreRepo concreteStoreRepo;

    @InjectMocks
    StoreService storeService = new StoreServiceImpl();

    Store testStore;

    Logger log = Logger.getLogger(getClass().getName());


    @BeforeEach
    void setUp() {

        Logger log = Logger.getLogger(getClass().getName());

        MockitoAnnotations.initMocks(this);
        testStore = new Store();

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void save() {

        when(storeService.save(testStore)).thenReturn(testStore);
        storeService.save(testStore);
        verify(storeRepo, times(1)).save(testStore);
    }

    @Test
    void findStoreById() {

        when(storeService.findStoreById(testStore.getId())).thenReturn(Optional.of(testStore));
        storeService.findStoreById(testStore.getId());
        verify(storeRepo, times(1)).findById(testStore.getId());
    }

    @Test
    void getAllStore() {

        List<Store> storeList = new ArrayList<>();
        when(storeService.getAllStore()).thenReturn(storeList);
        storeService.getAllStore();
        verify(storeRepo, times(1)).findAll();
    }

    @Test
    void updateStore() {

        when(storeService.save(testStore)).thenReturn(testStore);
        storeService.save(testStore);
        verify(storeRepo, times(1)).save(testStore);
    }

    @Test
    void deleteStore() {

        doNothing().when(storeRepo).deleteById(testStore.getId());
        storeService.deleteStore(testStore.getId());
        verify(storeRepo, times(1)).deleteById(testStore.getId());
    }

    @Test
    @Transactional
    void addPets() {

        Store savedStore = concreteStoreRepo.findById(2).orElse(null);
        assertThat(savedStore).isNotNull();
        assertThat(savedStore.getPetList()).hasSize(0);

        Pet pet = new Pet();
        pet.setAge(5);
        pet.setName("Lucky");
        pet.setSex(PetSex.MALE);
        pet.setTypes(PetTypes.DOG);
        pet.setBreed("Bull Dog");
        pet.setBirthdate(new Date());
        pet.setPetStore(savedStore);

        savedStore.addPet(pet);
        concreteStoreRepo.save(savedStore);

        //retrieve store
        Store savedStore2 = concreteStoreRepo.findById(2).orElse(null);
        assertNotNull(savedStore2);

        //verify that pet is added to store
        assertThat(savedStore2.getPetList()).hasSize(1);
        assertThat(savedStore2.getPetList().get(0)).isNotNull();


        log.info("Added Pet to Store and Retrieved Pet from Store ---> Passed");

    }
}