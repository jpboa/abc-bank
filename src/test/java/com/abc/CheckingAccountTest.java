package com.abc;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CheckingAccountTest {

    private static final double DOUBLE_DELTA = 1e-15;

    private CheckingAccount account;

    @Before
    public void setUp() {
        account = new CheckingAccount();
    }

    @Test
    public void interestEarnedWith1000Deposit() {
        account.deposit(1000d);
        assertEquals(1.0, account.interestEarned(), DOUBLE_DELTA);
    }
}
