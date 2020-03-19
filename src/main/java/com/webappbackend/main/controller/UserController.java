package com.webappbackend.main.controller;

import com.webappbackend.main.entity.User;
import com.webappbackend.main.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @CrossOrigin(origins = "http://localhost:8080")
    public String login(@RequestBody User user) {
        System.out.println("password : " + user.getPassword() + ", username: " + user.getUsername());
        User result = userRepository.findUserByUsername(user.getUsername());
        if (result != null) {
            if (!result.getPassword().equals(user.getPassword())) {
                System.out.println("username or password is wrong");
                return "1";
            } else {
                System.out.println("login successfully");
                return "2";
            }
        } else {
            System.out.println("user is not exist");
            return "0";
        }
    }

    @ResponseBody
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @CrossOrigin(origins = "http://localhost:8080")
    public String register(@RequestBody User user) {
        System.out.println(user);
        User result = userRepository.findUserByUsername(user.getUsername());
        if (result == null) {
            userRepository.save(user);
            System.out.println("Inserting successfully");
            return "1";
        } else {
            System.out.println(user.getUsername() + " is already existed");
            return "0";
        }
    }

    @RequestMapping(value = "/authority", method = RequestMethod.GET)
    String obtainAuthority(@RequestParam(value = "username") String username) {
        return userRepository.findUserByUsername(username).getAuthority().toString();
    }

    @RequestMapping(value = "/getUserIdByUsernameAndPassword", method = RequestMethod.GET)
    String obtainUserId(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password) {
        System.out.println(username + " " + password);
        return userRepository.findUserByUsernameAndPassword(username, password).getUserId().toString();
    }

    @RequestMapping(value = "/updateUserProfile", method = RequestMethod.POST)
    @CrossOrigin(origins = "http://localhost:8080")
    String updateUserProfile(@RequestBody User user) {
        System.out.println(user);
        return  userRepository.update(
                user.getUsername(),
                user.getEmail(),
                user.getAddress(),
                user.getCity(),
                user.getCountry(),
                user.getPassword(),
                user.getFirstName(),
                user.getLastName(),
                user.getUserId()
        ) == null ? "0" : "1";
    }

//    @RequestMapping(value = "/getUserProfile", method = RequestMethod.GET)
//    User getUserProfile(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password) {
//        return userRepository.findUserByUsernameAndPassword(username, password);
//    }
    @RequestMapping(value = "/getUserProfile", method = RequestMethod.POST)
    @CrossOrigin("http://localhost:8080")
    User getUserProfile(@RequestBody User user) {
        return userRepository.findUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @RequestMapping(value = "/allUsers", method = RequestMethod.GET)
    List<User> allUser() {
        return userRepository.findAll();
    }

    @RequestMapping(value = "/deleteUserByUserId", method = RequestMethod.POST)
    @CrossOrigin("http://localhost:8080")
    String deleteUserByUserId(@RequestBody User user) {
        return userRepository.deleteUserByUserId(user.getUserId()) == null ? "0" : "1";
    }
}
