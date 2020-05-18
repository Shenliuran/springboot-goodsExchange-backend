package com.webappbackend.main.repository;

import com.webappbackend.main.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    List<Transaction> findAllByReceiverId(Integer receiverId);
    List<Transaction> findAllBySponsorId(Integer sponsorId);
    @Transactional
    String deleteTransactionByTransactionId(Integer goodsId);

    @Modifying
    @Transactional
    @Query(value = "update Transaction t set t.status = ?1 where t.sponsorId = ?2 and t.receiverId = ?3")
    void updateStatus(Integer status, Integer sponsorId, Integer receiverId);
}
