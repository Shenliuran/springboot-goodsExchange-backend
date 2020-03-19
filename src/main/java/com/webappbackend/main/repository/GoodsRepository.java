package com.webappbackend.main.repository;

import com.github.pagehelper.Page;
import com.webappbackend.main.entity.Goods;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface GoodsRepository extends JpaRepository<Goods, Integer> {
    Page<Goods> findAllByIsSelected(Integer isSelected, Pageable pageable);
    List<Goods> findAllByOwnerId(Integer ownerId);
    @Transactional
    String deleteByGoodsId(Integer goodsId);
    Goods findGoodsByGoodsNameAndCategoryAndOwnerId(String goodsName, String category, Integer ownerId);

    @Modifying
    @Transactional
    @Query(value =
                "update Goods g set " +
                "g.goodsName = ?1," +
                "g.category = ?2," +
                "g.description = ?3," +
                "g.picture = ?4" +
                " where g.goodsId = ?5"
    )
    Integer updateGoods(String goodsName, String category, String description, String picture, Integer goodsId);
}
