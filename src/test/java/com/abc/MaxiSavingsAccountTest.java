package com.abc;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class MaxiSavingsAccountTest {

    private static final double DOUBLE_DELTA = 1e-15;

    private MaxiSavingsAccount account;

    @Before
    public void setUp() {
        account = new MaxiSavingsAccount();
    }

    @Test
    public void interestEarnedWhenNoWithdrawalInPastTenDays() {
        account.deposit(1000d);
        assertEquals(50.0, account.interestEarned(), DOUBLE_DELTA);
    }

    @Test
    public void interestEarnedWhenWithdrawalInPastTenDays() {
        account.deposit(2000d);
        account.withdraw(1000d);

        assertEquals(1.0, account.interestEarned(), DOUBLE_DELTA);
    }

}
