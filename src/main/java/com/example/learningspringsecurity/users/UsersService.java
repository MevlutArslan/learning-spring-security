package com.example.learningspringsecurity.users;

import com.example.learningspringsecurity.item.Item;
import com.example.learningspringsecurity.item.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UsersService {

    private UsersRepository usersRepository;
    private ItemRepository itemRepository;

    @Autowired
    public UsersService(UsersRepository usersRepository, ItemRepository itemRepository) {
        this.usersRepository = usersRepository;
        this.itemRepository = itemRepository;
    }

    public Users getUserByID(Long id) {
        return this.usersRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public Users getUserByIdentificationNumber(String identificationNumber) {
        return this.usersRepository.findByIdentificationNumber(identificationNumber);
    }

    public List<Users> getUsers() {
        return this.usersRepository.findAll();
    }

    @Transactional
    public void rentItem(Long userID, Long itemID){
        Users user = this.usersRepository.findById(userID).orElseThrow(NoSuchElementException::new);
        Item item = this.itemRepository.findById(itemID).orElseThrow(NoSuchElementException::new);

        user.rentItem(item);
    }

    @Transactional
    public void returnItem(Long userID, Long itemID){
        Users user = this.usersRepository.findById(userID).orElseThrow(NoSuchElementException::new);
        Item item = this.itemRepository.findById(itemID).orElseThrow(NoSuchElementException::new);

        user.returnItem(item);
    }

    public void addUser(Users user) throws Exception {
        if (this.usersRepository.findByIdentificationNumber(user.getIdentificationNumber()) != null) {
            throw new Exception("User with identification number : " + user.getIdentificationNumber() + " exists already!");
        }
        this.usersRepository.save(user);
    }

    public void deleteUser(Long id) {
        Users user = this.usersRepository.findById(id).orElseThrow(NoSuchElementException::new);

        this.usersRepository.delete(user);
    }

}
