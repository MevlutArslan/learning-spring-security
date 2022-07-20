package com.example.learningspringsecurity.item;

import com.example.learningspringsecurity.users.Users;
import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotBlank
    private int price;

    @Column
    @DateTimeFormat(pattern = "YYYY-MM-DD")
    private LocalDate rentedOn;

    @Column
    @ManyToOne
    @JsonBackReference
    private Users rentedBy;

    public Item() {

    }

    public Item(int price) {
        this.price = price;
    }

    public void setRentedOn(LocalDate rentedOn) {
        this.rentedOn = rentedOn;
    }

    public void setRentedBy(Users rentedBy) {
        this.rentedBy = rentedBy;
    }

    public Users getRentedBy(){
        return this.rentedBy;
    }

    public LocalDate getRentedOn() {
        return rentedOn;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
