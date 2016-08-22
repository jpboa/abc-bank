package com.abc;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AccountTest {
    
    private static final double DOUBLE_DELTA = 1e-15;

    private Account account;

    @Before
    public void setUp() {
        account = new Account("No interest") {

            @Override
            public double interestEarned() {
                return 0.0;
            }
        };
    }
    
    @Test
    public void getAccountName() {
        assertEquals("No interest", account.getAccountName());
    }
    
    @Test
    public void deposit() {
        account.deposit(100d);
        
        assertEquals(1, account.getTransactions().size());
        assertEquals(100.0, account.getTransactions().get(0).getAmount(), DOUBLE_DELTA);
    }

    @Test(expected = IllegalArgumentException.class)
    public void depositZero() {
        account.deposit(0d);
        Assert.fail();
    }

    @Test(expected = IllegalArgumentException.class)
    public void depositNegative() {
        account.deposit(-100d);
        Assert.fail();
    }
    
    @Test
    public void withdraw() {
        account.withdraw(100d);
        
        assertEquals(1, account.getTransactions().size());
        assertEquals(-100.0, account.getTransactions().get(0).getAmount(), DOUBLE_DELTA);
    }

    @Test(expected = IllegalArgumentException.class)
    public void withdrawZero() {
        account.withdraw(0d);
        Assert.fail();
    }

    @Test(expected = IllegalArgumentException.class)
    public void withdrawNegative() {
        account.withdraw(-100d);
        Assert.fail();
    }

    @Test
    public void sumTransactions() {
        account.deposit(200d);
        account.sumTransactions();
    }
}
