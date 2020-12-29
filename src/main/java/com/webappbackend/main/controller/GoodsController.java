package com.webappbackend.main.controller;

import com.webappbackend.main.entity.Goods;
import com.webappbackend.main.repository.GoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    GoodsRepository goodsRepository;

    @RequestMapping("/findAllByIsSelected")
    @CrossOrigin("http://localhost:8080")
    public List<Goods> findAllByIsSelected(@RequestParam(value = "page") Integer page, @RequestParam(value = "size") Integer size) {
        PageRequest request = PageRequest.of(page, size);
        return goodsRepository.findAllByIsSelected(0, request);
    }

    @RequestMapping(value = "/addGoods", method = RequestMethod.POST)
    @CrossOrigin("http://localhost:8080")
    public String addGoods(@RequestBody Goods goods) throws IOException {
        System.out.println(goods);
        goods.setIsSelected(0);
        return !goodsRepository.save(goods).equals(new Goods()) ? "1" : "0";
    }

    @RequestMapping(value = "/findGoodsByOwnerId", method = RequestMethod.GET)
    @CrossOrigin("http://localhost:8080")
    public List<Goods> findGoodsByOwnerId(@RequestParam(value = "ownerId") Integer ownerId) {
        System.out.println("ownerId= " + ownerId);
        return goodsRepository.findAllByOwnerId(ownerId);
    }

    @RequestMapping(value = "/deleteGoodsByGoodsId", method = RequestMethod.POST)
    @CrossOrigin("http://localhost:8080")
    public String deleteGoodsByGoodsId(@RequestBody Goods goods) {
        return goodsRepository.deleteByGoodsId(goods.getGoodsId()) == null ? "0" : "1";
    }

    @RequestMapping(value = "/getGoodsId", method = RequestMethod.GET)
    @CrossOrigin("http://localhost:8080")
    public Integer obtainGoodsId(
            @RequestParam(value = "goodsName") String goodsName,
            @RequestParam(value = "category") String category,
            @RequestParam(value = "ownerId") Integer ownerId) {
        return goodsRepository.findGoodsByGoodsNameAndCategoryAndOwnerId(goodsName, category, ownerId).getGoodsId();
    }

    @RequestMapping(value = "/updateGoods", method = RequestMethod.POST)
    @CrossOrigin(origins = "http://localhost:8080")
    public String updateGoods(@RequestBody Goods goods) {
        return goodsRepository.updateGoods(
                goods.getGoodsName(),
                goods.getCategory(),
                goods.getDescription(),
                goods.getPicture(),
                goods.getContact(),
                goods.getGoodsId()
        ) == null ? "0" : "1";
    }

    @RequestMapping(value = "/allGoods", method = RequestMethod.GET)
    @CrossOrigin("http://localhost:8080")
    public List<Goods> findAllGoods() {
        return goodsRepository.findAll();
    }

    @RequestMapping(value = "/updateIsSelected", method = RequestMethod.GET)
    @CrossOrigin("http://localhost:8080")
    public void updateIsSelected(@RequestParam(value = "goodsId") Integer goodsId) {
        goodsRepository.updateIsSelected(1, goodsId);
    }
}

