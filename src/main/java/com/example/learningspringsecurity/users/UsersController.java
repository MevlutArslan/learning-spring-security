package com.example.learningspringsecurity.users;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/api/v1/users")
public class UsersController {

    private UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping
    public List<Users> getUsers() {
        return this.usersService.getUsers();
    }

    @GetMapping("/{id}")
    public Users getUserByID(@PathVariable String id) {
        return this.usersService.getUserByID(Long.parseLong(id));
    }

    @GetMapping("/getByIdentificationNumber/{identificationNumber}")
    public Users getUserByIdentificationNumber(@PathVariable String identificationNumber) {
        return this.usersService.getUserByIdentificationNumber(identificationNumber);
    }

    @PostMapping
    public void addUser(@RequestBody Users user) throws Exception {
        this.usersService.addUser(user);
    }

    @PostMapping("/{userID}/rentItem/{itemID}")
    public void rentItem(@PathVariable String userID, @PathVariable String itemID) {
        this.usersService.rentItem(Long.parseLong(userID), Long.parseLong(itemID));
    }

    @PostMapping("/{userID}/returnItem/{itemID}")
    public void returnItem(@PathVariable String userID, @PathVariable String itemID) {
        this.usersService.returnItem(Long.parseLong(userID), Long.parseLong(itemID));
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id) {
        this.usersService.deleteUser(Long.parseLong(id));
    }


}
