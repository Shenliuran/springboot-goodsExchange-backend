package com.webappbackend.main.entity;

import lombok.Data;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;

@Entity
@Table(name = "shopping_car")
@Data
public class ShoppingCar {
    @Id
    @Column(name = "shopping_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer shoppingId;

    @Column(name = "goods_id")
    private Integer goodsId;

    @Column(name = "user_id", nullable = false)
    private Integer userId;
}
