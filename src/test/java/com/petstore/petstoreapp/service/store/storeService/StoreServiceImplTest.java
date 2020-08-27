package com.petstore.petstoreapp.service.store.storeService;

import com.petstore.petstoreapp.models.Pet;
import com.petstore.petstoreapp.models.Store;
import com.petstore.petstoreapp.repository.StoreRepo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mock.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StoreServiceImplTest {

    @Mock
    StoreRepo storeRepo;

    @InjectMocks
    StoreService storeService;

    Store testStore;

    @BeforeEach
    void setUp() {


        storeService = new StoreServiceImpl();
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
    void addPets() {
    }
}