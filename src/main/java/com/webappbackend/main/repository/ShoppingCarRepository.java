package com.webappbackend.main.repository;


import com.webappbackend.main.entity.ShoppingCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ShoppingCarRepository extends JpaRepository<ShoppingCar, Integer> {
    List<ShoppingCar> findAllByUserId(Integer userId);
    @Transactional
    void deleteByGoodsIdAndUserId(Integer goodsId, Integer userId);
}
