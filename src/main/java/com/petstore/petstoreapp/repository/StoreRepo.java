package com.petstore.petstoreapp.repository;

import com.petstore.petstoreapp.models.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Id;

public interface StoreRepo extends JpaRepository<Store, Id> {
}
