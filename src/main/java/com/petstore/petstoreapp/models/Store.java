package com.petstore.petstoreapp.models;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "store")
public class Store{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Column(nullable = false)
    private String storeName;

    @Column(nullable = false)
    private Integer storeNumber;

    @OneToMany(mappedBy = "petStore", fetch = FetchType.LAZY, cascade = CascadeType.ALL) // one store to Many Pet
    private List<Pet> petList;

    public Integer getId() {
        return Id;
    }

    private String address;

    private String city;

    private String state;

    private String country;


    public void setId(Integer id) {
        Id = id;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public Integer getStoreNumber() {
        return storeNumber;
    }

    public void setStoreNumber(Integer storeNumber) {
        this.storeNumber = storeNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Pet> getPetList() {
        return petList;
    }

    public void setPetList(List<Pet> petList) {
        this.petList = petList;
    }

    public void addPet(Pet onePet){

        if(this.petList == null){
            this.petList = new ArrayList<>();
        }
        this.petList.add(onePet);
    }

    @Override
    public String toString() {
        return "Store{" +
                "Id=" + Id +
                ", storeName='" + storeName + '\'' +
                ", storeNumber=" + storeNumber +
                ", petList=" + petList +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
