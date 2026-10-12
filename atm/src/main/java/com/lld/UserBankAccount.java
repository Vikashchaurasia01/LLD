package com.lld;

public class UserBankAccount {

    public int balance;

    public void withdrawlBalance(int amount) {
        balance = balance - amount;
    }
    
}
