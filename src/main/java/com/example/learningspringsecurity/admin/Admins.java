package com.example.learningspringsecurity.admin;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class Admins {

    @GeneratedValue
    @Id
    private Long id;

    @Column
    @NotEmpty
    private String firstName;

    @Column
    @NotEmpty
    private String surname;

    @Column
    @NotEmpty
    private String email;

    @Column
    @NotEmpty
    private String password;

    public Admins(String firstName, String surname, String email) {
        this.firstName = firstName;
        this.surname = surname;
        this.email = email;
        this.password = password;
    }

    public Admins() {

    }

    public Long getId(){
        return this.id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
