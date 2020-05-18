package com.webappbackend.main.controller;

import com.webappbackend.main.entity.Goods;
import com.webappbackend.main.entity.ShoppingCar;
import com.webappbackend.main.repository.GoodsRepository;
import com.webappbackend.main.repository.ShoppingCarRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ShoppingCarControllerTest {

    @Autowired
    private ShoppingCarRepository shoppingCarRepository;
    @Autowired
    private GoodsRepository goodsRepository;
    @Test
    void getShoppingCarByUserId() {
        List<Goods> list = new ArrayList<>();
        for (ShoppingCar car : shoppingCarRepository.findAllByUserId(11)) {
            Goods goods = goodsRepository.getOne(car.getGoodsId());
            list.add(goods);
        }
        System.out.println(list);
    }
}