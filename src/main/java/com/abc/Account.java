package com.abc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Account {

    private final String accountName;
    protected final List<Transaction> transactions;

    public Account(String name) {
        this.accountName = name;
        this.transactions = new ArrayList<Transaction>();
    }
    
    public String getAccountName() {
        return accountName;
    }
    
    public List<Transaction> getTransactions() {
        return Collections.unmodifiableList(transactions);
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("amount must be greater than zero");
        } else {
            transactions.add(new Transaction(amount));
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("amount must be greater than zero");
        } else {
            transactions.add(new Transaction(-amount));
        }
    }

    public abstract double interestEarned();
    
    public double sumTransactions() {
        return transactions.stream().mapToDouble(t -> t.getAmount()).sum();
    }
}