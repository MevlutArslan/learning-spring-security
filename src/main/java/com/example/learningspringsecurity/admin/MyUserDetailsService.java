package com.example.learningspringsecurity.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private AdminService adminService;

    @Override
    public UserDetails loadUserByUsername(String email) throws NoSuchElementException {
        Admins admins = adminService.getAdminByEmail(email);
        return buildUserForAuthentication(admins);
    }

    private UserDetails buildUserForAuthentication(Admins admins) {
        return new org.springframework.security.core.userdetails.User(admins.getEmail(), admins.getPassword(), null);
    }
}
