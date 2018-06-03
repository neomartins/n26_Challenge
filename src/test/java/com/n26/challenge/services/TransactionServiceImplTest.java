package com.n26.challenge.services;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.n26.challenge.entity.Transaction;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TransactionServiceImplTest {

	@Autowired
	private TransactionService transactionService;


	@Before
	public void setUp() {
		transactionService.clear();
	}

	@Test(expected = RuntimeException.class)
	public void addTransactionOutOfLimitTime() {
		Transaction transaction = new Transaction();
		transaction.setAmount(1.0);
		transaction.setTimestamp(new Date(System.currentTimeMillis() - 100000).getTime());

		transactionService.addTransaction(transaction);

	}

	@Test(expected = RuntimeException.class)
	public void addTransactionNegativeAmount() {
		Transaction transaction = new Transaction();
		transaction.setAmount(-1.0);
		transaction.setTimestamp(new Date(System.currentTimeMillis() - 100000).getTime());

		transactionService.addTransaction(transaction);

	}

	@Test
	public void addTransactionSucess() {
		Transaction transaction = new Transaction();
		transaction.setAmount(1.0);
		transaction.setTimestamp(new Date(System.currentTimeMillis()).getTime());

		transactionService.addTransaction(transaction);

	}

	@Test
	public void addTwoTransaction() {
		Transaction transaction = new Transaction();
		transaction.setAmount(1.0);
		transaction.setTimestamp(new Date(System.currentTimeMillis()).getTime());

		transactionService.addTransaction(transaction);

		Transaction transactionTwo = new Transaction();
		transactionTwo.setAmount(1.0);
		transactionTwo.setTimestamp(new Date(System.currentTimeMillis()).getTime());

		transactionService.addTransaction(transactionTwo);

	}

}