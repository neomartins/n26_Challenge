package com.n26.challenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.n26.challenge.entity.Transaction;
import com.n26.challenge.services.TransactionService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "api/transactions")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping
    @ApiOperation(value = "Add Transaction")
    public ResponseEntity<?> addTransaction(@RequestBody Transaction transaction) {
    	try{
    	     transactionService.addTransaction(transaction);
    		 return new ResponseEntity<>( HttpStatus.OK);
    	}catch (Exception e) {
    		return new ResponseEntity<>(e.getMessage(), HttpStatus.NO_CONTENT);
		}
       
    }

}
