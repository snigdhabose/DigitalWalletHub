package com.example.demo.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.example.demo.models.Transaction;
@Component
public interface TransactionService extends JpaRepository<Transaction,Integer>{

}
