package com.petstore.petstoreapp.service.store.storeService;

import com.petstore.petstoreapp.models.Pet;
import com.petstore.petstoreapp.models.Store;
import com.petstore.petstoreapp.service.exceptions.StoreObjectNotPresentException;

import java.util.List;
import java.util.Optional;

public interface StoreService {


    Store save(Store store);

    Optional<Store> findStoreById(Integer StoreId);

    List<Store> getAllStore();

    Store UpdateStore(Store store);

    void deleteStore(Integer id);

    Store addPets(Pet pet, Integer storeId) throws StoreObjectNotPresentException;
}
