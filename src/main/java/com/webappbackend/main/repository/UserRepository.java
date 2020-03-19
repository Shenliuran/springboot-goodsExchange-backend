package com.webappbackend.main.repository;

import com.github.pagehelper.Page;
import com.webappbackend.main.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserByUsername(String  username);
    User findUserByUsernameAndPassword(String username, String password);
    @Transactional
    String deleteUserByUserId(Integer userId);
    @Modifying
    @Transactional
    @Query(value =
                    "update User u set " +
                    "u.username = ?1," +
                    "u.email = ?2," +
                    "u.address = ?3," +
                    "u.city = ?4," +
                    "u.country = ?5," +
                    "u.password = ?6," +
                    "u.firstName = ?7," +
                    "u.lastName = ?8" +
                    " where u.userId = ?9"
    )
    Integer update(
            String username,
            String email,
            String address,
            String city,
            String country,
            String password,
            String firstName,
            String lastName,
            Integer userId
    );
}
