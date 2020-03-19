package com.webappbackend.main.entity;

import lombok.Data;
import org.springframework.boot.configurationprocessor.json.JSONObject;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "user")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "username", nullable = false, columnDefinition = "varchar(20)")
    private String username;

    @Column(name = "password", nullable = false, columnDefinition = "varchar(20)")
    private String password;

    @Column(name = "authority", nullable = false, columnDefinition = "tinyint")
    private Boolean authority;

    @Column(name = "first_name", columnDefinition = "varchar(20)")
    private String firstName;

    @Column(name = "last_name", columnDefinition = "varchar(20)")
    private String lastName;

    @Column(name = "email", columnDefinition = "varchar(50)")
    private String email;

    @Column(name = "address", columnDefinition = "varchar(50)")
    private String address;

    @Column(name = "country", columnDefinition = "varchar(20)")
    private String country;

    @Column(name = "city", columnDefinition = "varchar(50)")
    private String city;
}
