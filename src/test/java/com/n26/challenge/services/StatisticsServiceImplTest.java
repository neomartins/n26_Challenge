package com.n26.challenge.services;

import static junit.framework.TestCase.assertEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.n26.challenge.entity.Statistics;
import com.n26.challenge.entity.Transaction;

@SpringBootTest
@RunWith(SpringRunner.class)
public class StatisticsServiceImplTest {
	
	@Autowired
	private TransactionService transactionService;
	
	@Autowired
	private StatisticsService statisticsService;
	
	@Before
    public void setUp() {
		transactionService.clear();
    }
	
	@Test 
	public void getStatisticsGetNothing(){
		Statistics statistics = statisticsService.getStatistics();
        assertEquals(statistics.getSum(),0.0);
        assertEquals(statistics.getAvg(),0.0);
        assertEquals(statistics.getMax(),0.0);
        assertEquals(statistics.getMin(),0.0);
        assertEquals(statistics.getCount(),0L);
	}
	
	@Test 
	public void getStatisticsReturnJustOne(){
		
		Transaction transaction = new Transaction();
		transaction.setAmount(1.0);
		transaction.setTimestamp(new Date(System.currentTimeMillis()).getTime());

		transactionService.addTransaction(transaction);
		
		Statistics statistics = statisticsService.getStatistics();
        assertEquals(statistics.getSum(),1.0);
        assertEquals(statistics.getAvg(),1.0);
        assertEquals(statistics.getMax(),1.0);
        assertEquals(statistics.getMin(),1.0);
        assertEquals(statistics.getCount(),1L);
	}
	
	@Test 
	public void getStatisticsReturnMoreThenOne(){
		
		Transaction transaction = new Transaction();
		transaction.setAmount(1.0);
		transaction.setTimestamp(new Date(System.currentTimeMillis()).getTime());

		transactionService.addTransaction(transaction);

		Transaction transactionTwo = new Transaction();
		transactionTwo.setAmount(4.0);
		transactionTwo.setTimestamp(new Date(System.currentTimeMillis()).getTime());

		transactionService.addTransaction(transactionTwo);
		
		Statistics statistics = statisticsService.getStatistics();
        assertEquals(statistics.getSum(),5.0);
        assertEquals(statistics.getAvg(),2.5);
        assertEquals(statistics.getMax(),4.0);
        assertEquals(statistics.getMin(),1.0);
        assertEquals(statistics.getCount(),2L);
	}

}
