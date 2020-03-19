package com.webappbackend.main.controller;

import com.webappbackend.main.repository.GoodsRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;


import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GoodsControllerTest {

    @Autowired
    private GoodsRepository goodsRepository;

    @Test
    void findAllByIsSelected() {
        PageRequest request = PageRequest.of(0, 3);
        System.out.println(goodsRepository.findAllByIsSelected(0, request).getResult().get(0));
    }
}