package com.abc;

public class CheckingAccount extends Account {

    private static final double RATE = 0.001;

    public CheckingAccount() {
        super("Checking Account");
    }

    @Override
    public double interestEarned() {
        return sumTransactions() * RATE;
    }
}
