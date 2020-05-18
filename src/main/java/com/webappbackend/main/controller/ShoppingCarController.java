package com.webappbackend.main.controller;

import com.webappbackend.main.entity.Goods;
import com.webappbackend.main.entity.ShoppingCar;
import com.webappbackend.main.repository.GoodsRepository;
import com.webappbackend.main.repository.ShoppingCarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/shoppingCar")
public class ShoppingCarController {

    @Autowired
    ShoppingCarRepository shoppingCarRepository;
    @Autowired
    GoodsRepository goodsRepository;

    @RequestMapping(value = "/getShoppingCarByUserId", method = RequestMethod.GET)
    @CrossOrigin("http://localhost:8080")
    public List<Goods> getShoppingCarByUserId(@RequestParam(value = "userId") Integer userId) {
        List<Goods> list = new ArrayList<>();
        for (ShoppingCar car : shoppingCarRepository.findAllByUserId(userId)) {
            list.add(goodsRepository.getOne(car.getGoodsId()));
        }
        return list;
    }

    @ResponseBody
    @RequestMapping(value = "/insertShoppingCar", method = RequestMethod.POST)
    @CrossOrigin("http://localhost:8080")
    public ShoppingCar insertShoppingCar(@RequestBody ShoppingCar shoppingCar) {
        return shoppingCarRepository.save(shoppingCar);
    }

    @ResponseBody
    @RequestMapping(value = "/deleteShoppingCar", method = RequestMethod.GET)
    @CrossOrigin("http://localhost:8080")
    public void deleteShoppingCar(@RequestParam(value = "goodsId")Integer goodsId, @RequestParam(value = "userId")Integer userId)  {
        shoppingCarRepository.deleteByGoodsIdAndUserId(goodsId, userId);
    }
}
