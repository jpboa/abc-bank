package com.abc;

import java.time.LocalDate;

public class MaxiSavingsAccount extends Account {
    
    private static final long BONUS_PERIOD_IN_DAYS = 10;
    private static final double DEFAULT_RATE = 0.001;
    private static final double BONUS_RATE = 0.05;

    public MaxiSavingsAccount() {
        super("Maxi Savings Account");
    }

    @Override
    public double interestEarned() {
        double rate = hasWithdrawalsWithin(BONUS_PERIOD_IN_DAYS) ? DEFAULT_RATE : BONUS_RATE;
        return sumTransactions() * rate;
    }
    
    private boolean hasWithdrawalsWithin(long days) {
        LocalDate tenDaysAgo = LocalDate.now().minusDays(days);
                
        long count = this.transactions.stream()
                .filter(t -> t.getAmount() < 0 && t.getTransactionDate().isAfter(tenDaysAgo))
                .count();

        return count > 0;
    }
}
