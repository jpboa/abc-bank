package com.abc;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CustomerTest {
    
    private static final double DOUBLE_DELTA = 1e-15;
    
    private Customer customer;
    private SavingsAccount savingsAccount;
    private CheckingAccount checkingAccount;
    private MaxiSavingsAccount maxiSavingsAccount;
    
    @Before
    public void setUp() {
        customer = new Customer("Henry");
        savingsAccount = new SavingsAccount();
        checkingAccount = new CheckingAccount();
        maxiSavingsAccount = new MaxiSavingsAccount();
    }

    @Test
    public void customerStatementGeneration(){
        customer.openAccount(checkingAccount).openAccount(savingsAccount);

        checkingAccount.deposit(100.0);
        savingsAccount.deposit(4000.0);
        savingsAccount.withdraw(200.0);
        
        assertEquals("Statement for Henry\n" +
                "\n" +
                "Checking Account\n" +
                "  deposit $100.00\n" +
                "Total $100.00\n" +
                "\n" +
                "Savings Account\n" +
                "  deposit $4,000.00\n" +
                "  withdrawal $200.00\n" +
                "Total $3,800.00\n" +
                "\n" +
                "Total In All Accounts $3,900.00", customer.getStatement());
    }

    @Test
    public void openOneAccount(){
        customer.openAccount(savingsAccount);
        assertEquals(1, customer.getNumberOfAccounts());
    }

    @Test
    public void openTwoAccounts(){
        customer.openAccount(savingsAccount)
            .openAccount(checkingAccount);
        
        assertEquals(2, customer.getNumberOfAccounts());
    }

    @Test
    public void openThreeAccounts() {
        customer.openAccount(savingsAccount)
            .openAccount(checkingAccount)
            .openAccount(maxiSavingsAccount);
    
        assertEquals(3, customer.getNumberOfAccounts());
    }
    
    @Test
    public void openNoAccount() {
        assertEquals(0, customer.getNumberOfAccounts());
    }
    
    @Test
    public void transfer() {
        customer.openAccount(checkingAccount).openAccount(savingsAccount);
        checkingAccount.deposit(100.0);
        customer.transfer(60.0, checkingAccount, savingsAccount);
        
        assertEquals(40.0, checkingAccount.sumTransactions(), DOUBLE_DELTA);
        assertEquals(60.0, savingsAccount.sumTransactions(), DOUBLE_DELTA);
    }
    
    @Test
    public void totalInterestEarnedWithNoAccount() {
        customer.totalInterestEarned();
        
        assertEquals(0.0, customer.totalInterestEarned(), DOUBLE_DELTA);        
    }
    
    @Test
    public void totalInterestEarnedWithOneAccount() {
        customer.openAccount(savingsAccount);
        savingsAccount.deposit(1000.0);
        
        assertEquals(1.0, customer.totalInterestEarned(), DOUBLE_DELTA);        
    }

    @Test
    public void totalInterestEarnedWithTwoAccount() {
        customer.openAccount(savingsAccount).openAccount(maxiSavingsAccount);
        
        savingsAccount.deposit(1000.0);
        maxiSavingsAccount.deposit(100.0);
        
        assertEquals(6.0, customer.totalInterestEarned(), DOUBLE_DELTA);        
    }
}