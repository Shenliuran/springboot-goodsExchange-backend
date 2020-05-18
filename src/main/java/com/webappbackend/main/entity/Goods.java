package com.webappbackend.main.entity;

import lombok.Data;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;

@Entity
@Table(name = "goods")
@Data
@Proxy(lazy = false)
public class Goods {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "goods_id")
    private Integer goodsId;

    @Column(name = "goods_name", columnDefinition = "varchar(50)", nullable = false)
    private String goodsName;

    @Column(name = "category", columnDefinition = "varchar(255)")
    private String category;

    @Column(name = "owner_id", nullable = false)
    private Integer ownerId;

    @Column(name = "owner_name", columnDefinition = "varchar(20)")
    private String ownerName;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "picture", columnDefinition = "longblob")
    private String picture;

    @Column(name = "is_selected", columnDefinition = "tinyint")
    private Integer isSelected;

    @Column(name = "description", columnDefinition = "longtext")
    private String description;

    @Column(name = "contact", columnDefinition = "varchar(50)")
    private String contact;
}
