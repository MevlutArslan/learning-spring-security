package com.example.learningspringsecurity.users;

import com.example.learningspringsecurity.item.Item;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotBlank
    private String identificationNumber;

    @OneToMany
    @JsonManagedReference
    private List<Item> rentedItems;

    public Users() {
    }

    public Users(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public void rentItem(Item item) {
        this.rentedItems.add(item);
        item.setRentedBy(this);
        item.setRentedOn(LocalDate.now());
    }

    public void returnItem(Item item) {
        this.rentedItems.remove(item);
        item.setRentedBy(null);
        item.setRentedOn(null);
    }

    public Long getId() {
        return id;
    }

    public List<Item> getRentedItems() {
        return rentedItems;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }
}
