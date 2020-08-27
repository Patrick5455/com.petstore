package com.petstore.petstoreapp.service.store.storeService;

import com.petstore.petstoreapp.models.Pet;
import com.petstore.petstoreapp.models.Store;
import com.petstore.petstoreapp.repository.StoreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StoreServiceImpl  implements StoreService{

    @Autowired
    StoreRepo storeRepo;

    @Override
    public Store save(Store store) {
        return storeRepo.save(store);
    }

    @Override
    public Optional<Store> findStoreById(Integer storeId) {
        return storeRepo.findById(storeId);
    }

    @Override
    public List<Store> getAllStore() {
        return storeRepo.findAll();
    }

    @Override
    public Store UpdateStore(Store store) {
        return storeRepo.save(store);
    }

    @Override
    public void deleteStore(Integer storeId) {

        storeRepo.deleteById(storeId);

    }

    @Override
    public Store addPets(Pet pet) {
        return null;
    }
}
