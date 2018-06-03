package com.n26.challenge.services;

import java.util.UUID;
import java.util.concurrent.ConcurrentMap;

import com.n26.challenge.entity.Transaction;

public interface TransactionService {

    void addTransaction(Transaction transaction);

    ConcurrentMap<UUID, Transaction> getTransactions();
    
    void clear();

}
