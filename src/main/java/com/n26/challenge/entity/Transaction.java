package com.n26.challenge.entity;

import org.springframework.lang.NonNull;

public class Transaction {

	@NonNull
    private double amount;

    @NonNull
    private long timestamp;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
