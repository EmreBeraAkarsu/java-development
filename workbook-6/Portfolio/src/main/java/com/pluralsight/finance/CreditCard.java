package com.pluralsight.finance;

public class CreditCard implements IValuable{

    private String name;
    private String accountNumber;
    private double balance;

    public CreditCard(String name, String accountNumber, double balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void charge(double amount){


    }

    public void pay(double amount){


    }


    @Override
    public double getValue() {
        return 0;
    }
}
