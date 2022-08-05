package com.example.learningspringsecurity.admin;

import com.example.learningspringsecurity.user.Users;
import com.example.learningspringsecurity.user.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

    private AdminService adminService;
    private UsersService userService;

    @Autowired
    public AdminController(AdminService adminService, UsersService userService) {
        this.adminService = adminService;
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<Users> getUsers() {
        return this.userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public Users getUserById(@PathVariable String id) {
        return this.userService.getUserByID(Long.parseLong(id));
    }

    @PostMapping("/users")
    public void addUser(@RequestBody Users user) {
        this.userService.addUser(user);
    }

    @PostMapping()
    public void addAdmin(@RequestBody Admins admin) {
        System.out.println("WE ARE HERE!!");
        this.adminService.addAdmin(admin);
    }

}


