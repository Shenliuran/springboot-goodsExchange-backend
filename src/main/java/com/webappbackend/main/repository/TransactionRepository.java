package com.webappbackend.main.repository;

import com.webappbackend.main.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    List<Transaction> findAllByReceiverId(Integer receiverId);
    List<Transaction> findAllBySponsorId(Integer sponsorId);
    @Transactional
    String deleteTransactionByTransactionId(Integer goodsId);
}
