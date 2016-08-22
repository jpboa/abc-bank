package com.abc;

public class SavingsAccount extends Account {

    private static final double DEFAULT_RATE = 0.001;
    private static final double BONUS_RATE = 0.002;

    public SavingsAccount() {
        super("Savings Account");
    }

    @Override
    public double interestEarned() {
        double amount = sumTransactions();
        if (amount <= 1000) {
            return amount * DEFAULT_RATE;
        } else {
            return 1 + (amount - 1000) * BONUS_RATE;
        }
    }
}
