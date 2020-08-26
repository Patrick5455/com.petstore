package com.petstore.petstoreapp.models;

import javax.annotation.processing.Generated;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table()
public class Pet {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Column(nullable = false, length = 50)
    private String name;

    private String breed;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PetTypes types;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PetSex sex;

    @Column(nullable = false)
    private Integer age;

    private Date birthdate;


    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "store")
    private Store petStore;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public PetTypes getTypes() {
        return types;
    }

    public void setTypes(PetTypes types) {
        this.types = types;
    }

    public PetSex getSex() {
        return sex;
    }

    public void setSex(PetSex sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }


    public Store getPetStore() {
        return petStore;
    }

    public void setPetStore(Store petStore) {
        this.petStore = petStore;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", breed='" + breed + '\'' +
                ", types=" + types +
                ", sex=" + sex +
                ", age=" + age +
                ", birthdate=" + birthdate +
                '}';
    }
}
