package com.example.learningspringsecurity.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UsersService {

    private UsersRepository userRepository;

    @Autowired
    public UsersService(UsersRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    public Users getUserByID(Long id) {
        return this.userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public Users getUserByEmail(String email) {
        return this.userRepository.getUserByEmail(email).orElseThrow(NoSuchElementException::new);
    }

    public void addUser(Users user){
        this.userRepository.save(user);
    }

    public void deleteUser(Long id){
        Users user = this.userRepository.findById(id).orElseThrow(NoSuchElementException::new);
        this.userRepository.delete(user);
    }
}
