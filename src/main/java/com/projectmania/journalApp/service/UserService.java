package com.projectmania.journalApp.service;


import com.projectmania.journalApp.entity.User;
import com.projectmania.journalApp.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private static final PasswordEncoder encoder = new BCryptPasswordEncoder();
    @Autowired
    private PasswordEncoder passwordEncoder;



    private void ensureJournalEntriesInitialized(User user) {
        if (user.getJournalEntries() == null) {
            user.setJournalEntries(new ArrayList<>());
        }
    }


    public void saveAdmin(User user) {
        ensureJournalEntriesInitialized(user);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Arrays.asList("USER", "ADMIN"));
        userRepository.save(user);
    }

    public boolean saveNewUser(User user) {
        try {
            ensureJournalEntriesInitialized(user);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRoles(Arrays.asList("USER"));
            userRepository.save(user);
            return true;
        } catch (Exception e) {
            log.error("Error while saving user", e);
            return false;
        }
    }


    public void saveUser(User user) {
        userRepository.save(user);
    }

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public Optional<User> findById(ObjectId id){
        return userRepository.findById(id);
    }

    public void deleteById(ObjectId id){
        userRepository.deleteById(id);
    }

    public User findByUsername(String userName) {
        return userRepository.findByUserName(userName);
    }
}
