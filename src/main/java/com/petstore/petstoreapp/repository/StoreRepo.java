package com.petstore.petstoreapp.repository;

import com.petstore.petstoreapp.models.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;

@Repository
public interface StoreRepo extends JpaRepository<Store, Id> {

}
