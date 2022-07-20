package com.example.learningspringsecurity.users;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {

    Users findByIdentificationNumber(String identificationNumber);
}
