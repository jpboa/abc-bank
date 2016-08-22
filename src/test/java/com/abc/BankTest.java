package com.abc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;

public class BankTest {
    private static final double DOUBLE_DELTA = 1e-15;

    private Bank bank;

    @Before
    public void setUp() {
        bank = new Bank();
    }

    @Test
    public void customerSummaryWithNoCustomer() {
        assertEquals("Customer Summary", bank.customerSummary());
    }

    @Test
    public void customerSummaryWithOneCustomerWithNoAccount() {
        Customer john = new Customer("John");
        bank.addCustomer(john);

        assertEquals("Customer Summary\n - John (0 accounts)", bank.customerSummary());
    }

    @Test
    public void customerSummaryWithOneCustomer() {
        Customer john = new Customer("John");
        john.openAccount(new CheckingAccount());
        bank.addCustomer(john);

        assertEquals("Customer Summary\n - John (1 account)", bank.customerSummary());
    }

    @Test
    public void customerSummaryWithTwoCustomers() {
        Customer john = new Customer("John");
        john.openAccount(new CheckingAccount());
        bank.addCustomer(john);

        Customer harry = new Customer("Harry");
        harry.openAccount(new SavingsAccount());
        bank.addCustomer(harry);

        assertEquals("Customer Summary\n - John (1 account)\n - Harry (1 account)", bank.customerSummary());
    }

    @Test
    public void totalInterestPaidWhenNoCustomer() {
        assertEquals(0.0, bank.totalInterestPaid(), DOUBLE_DELTA);
    }

    @Test
    public void totalInterestPaidWithOneCustomer() {
        Account checkingAccount = new CheckingAccount();
        bank.addCustomer(new Customer("Bill").openAccount(checkingAccount));
        checkingAccount.deposit(1000.0);

        assertEquals(1.0, bank.totalInterestPaid(), DOUBLE_DELTA);
    }

    @Test
    public void totalInterestPaidWithTwoCustomer() {
        Account checkingAccount = new CheckingAccount();
        bank.addCustomer(new Customer("Bill").openAccount(checkingAccount));
        checkingAccount.deposit(1000.0);

        Account maxiSavingsAccount = new MaxiSavingsAccount();
        bank.addCustomer(new Customer("Larry").openAccount(maxiSavingsAccount));
        maxiSavingsAccount.deposit(100.0);
        
        assertEquals(6.0, bank.totalInterestPaid(), DOUBLE_DELTA);
    }
}