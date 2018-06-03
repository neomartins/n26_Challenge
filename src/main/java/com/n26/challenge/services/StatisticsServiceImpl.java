package com.n26.challenge.services;

import java.util.UUID;
import java.util.concurrent.ConcurrentMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.n26.challenge.entity.Statistics;
import com.n26.challenge.entity.Transaction;

@Service
public class StatisticsServiceImpl implements StatisticsService {

	@Autowired
	TransactionService transactionService;

	public Statistics getStatistics() {

		return this.mountStatistics(transactionService.getTransactions());
	}

	private Statistics mountStatistics(ConcurrentMap<UUID, Transaction> transactions) {
		Statistics statistics = new Statistics();
		statistics.setAvg(transactions.values().stream().mapToDouble(Transaction::getAmount).average().orElse(0.0));
		statistics.setCount(transactions.values().stream().mapToDouble(Transaction::getAmount).count());
		statistics.setMax(transactions.values().stream().mapToDouble(Transaction::getAmount).max().orElse(0.0));
		statistics.setMin(transactions.values().stream().mapToDouble(Transaction::getAmount).min().orElse(0.0));
		statistics.setSum(transactions.values().stream().mapToDouble(Transaction::getAmount).sum());

		return statistics;
	}

}
