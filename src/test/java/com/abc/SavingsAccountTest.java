package com.abc;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class SavingsAccountTest {

    private static final double DOUBLE_DELTA = 1e-15;

    private SavingsAccount account;

    @Before
    public void setUp() {
        account = new SavingsAccount();
    }

    @Test
    public void interestEarnedWith500Deposit() {
        account.deposit(500d);
        assertEquals(0.5, account.interestEarned(), DOUBLE_DELTA);
    }

    @Test
    public void interestEarnedWith1000Deposit() {
        account.deposit(1000d);
        assertEquals(1.0, account.interestEarned(), DOUBLE_DELTA);
    }

    @Test
    public void interestEarnedWith2000Deposit() {
        account.deposit(2000d);
        assertEquals(3.0, account.interestEarned(), DOUBLE_DELTA);
    }
}
