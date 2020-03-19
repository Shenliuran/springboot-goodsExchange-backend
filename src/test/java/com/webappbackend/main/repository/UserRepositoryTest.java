package com.webappbackend.main.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    void findUserByUsernameAndPassword() {
        System.out.println(userRepository.findUserByUsernameAndPassword("shen", "1234"));
    }

    @Test
    void update() {
//        userRepository.update("shen", "", "", "", "", "1234", 1);
    }
}