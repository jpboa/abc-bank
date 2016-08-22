package com.abc;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Bank {
    private List<Customer> customers;

    public Bank() {
        customers = new ArrayList<Customer>();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public String customerSummary() {
        StringBuilder summary = new StringBuilder("Customer Summary");

        String detail = customers.stream()
            .map(c -> ("\n - " + c.getName() + " (" + pluralize(c.getNumberOfAccounts(), "account") + ")"))
            .collect(Collectors.joining());
        
        summary.append(detail);

        return summary.toString();
    }
    
    private String pluralize(int number, String word) {
        return number + " " + (number == 1 ? word : word + "s");
    }

    public double totalInterestPaid() {
        return customers.stream().mapToDouble(customer -> customer.totalInterestEarned()).sum();
    }
}