package com.lld.ATMStates;

import com.lld.ATM;
import com.lld.Card;
import com.lld.TransactionType;

public abstract class ATMState {
    public void insertCard(ATM atm, Card card) {
        System.out.println("Invalid operation for current state.");
    }

    public void authenticatePin(ATM atm, Card card, int pin) {
        System.out.println("Invalid operation for current state.");
    }

    public void selectOperation(ATM atm, Card card, TransactionType transactionType) {
        System.out.println("Invalid operation for current state.");
    }

    public void cashWithdrawal(ATM atm, Card card, int amount) {
        System.out.println("Invalid operation for current state.");
    }

    public void displayBalance(ATM atm, Card card) {
        System.out.println("Invalid operation for current state.");
    }

    public void returnCard(){
        System.out.println("Invalid operation for current state.");
    }

    public void exit(ATM atm){
        System.out.println("Invalid operation for current state.");
    }
}
