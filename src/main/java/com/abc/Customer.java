package com.abc;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Math.abs;

public class Customer {
    private String name;
    private List<Account> accounts;

    public Customer(String name) {
        this.name = name;
        this.accounts = new ArrayList<Account>();
    }

    public String getName() {
        return name;
    }

    public Customer openAccount(Account account) {
        accounts.add(account);
        return this;
    }

    public int getNumberOfAccounts() {
        return accounts.size();
    }

    public double totalInterestEarned() {
        return accounts.stream().mapToDouble(account -> account.interestEarned()).sum();
    }

    public String getStatement() {
        StringBuilder customerStatement = new StringBuilder("Statement for " + name + "\n");

        Statement statement = accounts.stream()
                .map(account -> {
                    double accountTotal = account.sumTransactions();
                    return new Statement("\n" + statementForAccount(account, accountTotal) + "\n", accountTotal);
                })
                .collect(StatementCollector::new, StatementCollector::accept, StatementCollector::combine).getStatement();

        customerStatement.append(statement.getText());
        customerStatement.append("\nTotal In All Accounts ").append(toDollars(statement.getTotal()));
        return customerStatement.toString();
    }

    private String statementForAccount(Account account, double total) {
        StringBuilder statement = new StringBuilder(account.getAccountName()).append("\n");

        statement.append(account.getTransactions().stream()
                .map(t -> "  " + (t.getAmount() < 0 ? "withdrawal" : "deposit") + " " + toDollars(t.getAmount()) + "\n")
                .collect(Collectors.joining()));

        statement.append("Total ").append(toDollars(total));
        return statement.toString();
    }

    private String toDollars(double d) {
        return String.format("$%,.2f", abs(d));
    }

    public void transfer(double amount, Account checkingAccount, Account savingsAccount) {
        checkingAccount.withdraw(amount);
        savingsAccount.deposit(amount);
    }
}