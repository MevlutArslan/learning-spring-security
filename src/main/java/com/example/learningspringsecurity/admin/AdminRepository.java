package com.example.learningspringsecurity.admin;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admins, Long> {

    Admins getAdminByEmail(String email);
}
