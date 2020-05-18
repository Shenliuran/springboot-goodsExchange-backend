package com.webappbackend.main.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Transaction")
@Data
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private Integer transactionId;

    @Column(name = "goods_name")
    private String goodsName;

    @Column(name = "goods_id")
    private Integer goodsId;

    @Column(name = "sponsor_id")
    private Integer sponsorId;

    @Column(name = "sponsor_name")
    private String sponsorName;

    @Column(name = "receiver_name")
    private String receiverName;

    @Column(name = "receiver_id")
    private Integer receiverId;

    @Column(name = "status")
    private Integer status = 0;
}
