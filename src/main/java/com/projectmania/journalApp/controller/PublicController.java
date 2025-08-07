package com.projectmania.journalApp.controller;

import com.projectmania.journalApp.entity.User;
import com.projectmania.journalApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/public")
public class PublicController {

    @Autowired
    private UserService userService;



    @GetMapping("/health-check")
    public String HealthCheck() {
        return "OK";
    }

    @PostMapping("/create-user")
    public ResponseEntity<?> createUser(@RequestBody User user) {
        if (user.getJournalEntries() == null) {
            user.setJournalEntries(new ArrayList<>());
        }
        boolean success = userService.saveNewUser(user);
        if (success) {
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User creation failed.");
        }
    }



}
