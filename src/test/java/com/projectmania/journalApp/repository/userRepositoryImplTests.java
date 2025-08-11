package com.projectmania.journalApp.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class userRepositoryImplTests {

    @Autowired
    private UserRepositoryImpl userRepository;

    @Test
    public void testSaveNewUser(){
        Assertions.assertNotNull(userRepository.getUserForSA());
    }
}
