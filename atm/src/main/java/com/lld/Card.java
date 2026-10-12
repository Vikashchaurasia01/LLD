package com.lld;

public class Card {

    static int PIN_NUMBER = 112211;
    private UserBankAccount bankAccount;

    public boolean isCorrectPinEntered(int pin) {
        return pin == PIN_NUMBER;
    }

    public int getBalance() {
        return bankAccount.balance;
    }

    public void deductBankBalance(int amount) {
        bankAccount.withdrawlBalance(amount);
    }

    public void setBankAccount(UserBankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }
    
}
