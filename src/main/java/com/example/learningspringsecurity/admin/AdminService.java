package com.example.learningspringsecurity.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AdminService {

    private AdminRepository adminRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public AdminService(AdminRepository adminRepository, BCryptPasswordEncoder bCryptPasswordEncoder){
        this.adminRepository = adminRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public List<Admins> getAllAdmins(){
        return this.adminRepository.findAll();
    }

    public Admins getAdminById(Long id){
        return this.adminRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public Admins getAdminByEmail(String email){
        return this.adminRepository.getAdminByEmail(email);
    }

    public void addAdmin(Admins admins){
        admins.setPassword(bCryptPasswordEncoder.encode(admins.getPassword()));
        this.adminRepository.save(admins);
    }

    public void deleteAdmin(Long id){
        Admins admins = this.adminRepository.findById(id).orElseThrow(NoSuchElementException::new);
        this.adminRepository.delete(admins);
    }

}
