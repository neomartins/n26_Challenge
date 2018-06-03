package com.n26.challenge.services;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.n26.challenge.entity.Transaction;

@Service
public class TransactionServiceImpl implements TransactionService {

	private final ConcurrentMap<UUID, Transaction> transactions = new ConcurrentHashMap<>();

	@Override
	public void addTransaction(Transaction transaction) {
		if (transaction.getAmount() <= 0.0) {
			throw new RuntimeException();
		}

		if (!this.isInTheLastSecond(transaction.getTimestamp())) {
			throw new RuntimeException();
		}

		transactions.put(UUID.randomUUID(), transaction);
	}

	@Override
	public void clear() {
		transactions.clear();
	}

	private boolean isInTheLastSecond(long timestamp) {
		LocalDateTime date = LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), ZoneId.systemDefault());
		return date.isAfter(LocalDateTime.now().minusSeconds(60L));
	}

	@Override
	public ConcurrentMap<UUID, Transaction> getTransactions() {
		return transactions.entrySet().stream().filter(e -> this.isInTheLastSecond(e.getValue().getTimestamp()))
				.collect(Collectors.toConcurrentMap(e -> e.getKey(), e -> e.getValue()));
	}
}
