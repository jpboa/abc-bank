package com.abc;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TransactionTest {

    private static final double DOUBLE_DELTA = 1e-15;

    @Test
    public void getAmount() {
        Transaction t = new Transaction(5);
        assertEquals(5.0, t.getAmount(), DOUBLE_DELTA);
    }
}