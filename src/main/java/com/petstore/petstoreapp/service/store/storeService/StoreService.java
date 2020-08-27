package com.petstore.petstoreapp.service.store.storeService;

import com.petstore.petstoreapp.models.Pet;
import com.petstore.petstoreapp.models.Store;

import java.util.List;
import java.util.Optional;

public interface StoreService {


    Store save(Store store);

    Optional<Store> findStoreById(Integer StoreId);

    List<Store> getAllStore();

    Store UpdateStore(Store store);

    void deleteStore(Integer id);

    Store addPets(Pet pet);
}
