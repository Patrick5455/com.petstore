package com.petstore.petstoreapp.service.store.storeService;

import com.petstore.petstoreapp.models.Pet;
import com.petstore.petstoreapp.models.Store;
import com.petstore.petstoreapp.repository.StoreRepo;
import com.petstore.petstoreapp.service.exceptions.StoreObjectNotPresentException;
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
    public Store addPets(Pet pet, Integer storeId) throws NullPointerException, StoreObjectNotPresentException {

        // validate that pet is not null
        if(pet == null){
            throw new NullPointerException("Pet object should not be null");
        }

        //check that store exist
        Optional<Store> result = storeRepo.findById(storeId);

        if (result.isPresent()){

            Store savedStore = result.get();
            savedStore.addPet(pet);

            return storeRepo.save(savedStore);
        }

        else {

            throw new StoreObjectNotPresentException("Store not present in the database");
    }
}

    @Override
    public List<Pet> findStorePets(Integer storeId) throws StoreObjectNotPresentException {

        //find Store
        Optional<Store> result = storeRepo.findById(storeId);

        if (result.isPresent()){

            Store savedStore = result.get();

            return savedStore.getPetList();
        }

        //return petList

        else {
            throw  new StoreObjectNotPresentException("Store not present in the database");
        }
    }


}
