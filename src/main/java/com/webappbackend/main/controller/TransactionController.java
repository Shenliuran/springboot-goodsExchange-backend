package com.webappbackend.main.controller;

import com.webappbackend.main.entity.Transaction;
import com.webappbackend.main.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Column;
import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    TransactionRepository transactionRepository;

    @RequestMapping(value = "/getTransactionByReceiverId", method = RequestMethod.GET)
    @CrossOrigin("http://localhost:8080")
    public List<Transaction> getTransactionByReceiverId(@RequestParam(value = "receiverId") Integer receiverId) {
        return transactionRepository.findAllByReceiverId(receiverId);
    }

    @RequestMapping(value = "/getTransactionBySponsorId", method = RequestMethod.GET)
    @CrossOrigin("http://localhost:8080")
    public List<Transaction> getTransactionBySponsorId(@RequestParam(value = "sponsorId") Integer sponsorId) {
        return transactionRepository.findAllBySponsorId(sponsorId);
    }

    @RequestMapping(value = "/allTransaction", method = RequestMethod.GET)
    @CrossOrigin("http://localhost:8080")
    public List<Transaction> allTransaction() {
        return transactionRepository.findAll();
    }

    @RequestMapping(value = "/deleteTransactionByTransactionId", method = RequestMethod.POST)
    @CrossOrigin("http://localhost:8080")
    public String deleteTransaction(@RequestBody Transaction transaction) {
        return transactionRepository.deleteTransactionByTransactionId(transaction.getTransactionId()) == null ? "0" : "1";
    }

    @RequestMapping(value = "/addTransaction", method = RequestMethod.POST)
    @CrossOrigin("http://localhost:8080")
    public String addTransaction(@RequestBody Transaction transaction) {
        Transaction t = transaction;
        System.out.println(t);
        return transactionRepository.save(t).equals(new Transaction()) ? "0": "1";
    }

    @RequestMapping(value = "/updateStatus", method = RequestMethod.GET)
    @CrossOrigin("http://localhost:8080")
    public void updateStatus(
            @RequestParam(value = "status") Integer status,
            @RequestParam(value = "sponsorId") Integer sponsorId,
            @RequestParam(value = "receiverId") Integer receiverId) {
        transactionRepository.updateStatus(status, sponsorId, receiverId);
    }
}
