package com.example.springcaching.io.spring.boot.model;

public class Customer {
    private int accountNo;

    private String customerName;

    private String accountType;

    private double balance;

    public Customer() {
    }

    public Customer(int accountNo, String customerName, String accountType, double balance) {
        this.accountNo = accountNo;
        this.customerName = customerName;
        this.accountType = accountType;
        this.balance = balance;
    }

    public int getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
