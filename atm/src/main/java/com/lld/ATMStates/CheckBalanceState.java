package com.lld.ATMStates;

import com.lld.ATM;
import com.lld.Card;

public class CheckBalanceState extends ATMState {
    public CheckBalanceState() {
        System.out.println("ATM is in Check Balance State.");
    }

    @Override 
    public void displayBalance(ATM atm, Card card) {
        System.out.println("Current balance: " + card.getBalance());
        exit(atm);
    }

    @Override 
    public void exit(ATM atm) {
        returnCard();
        atm.setCurrentATMState(new IdleState());
        System.out.println("Card returned. Exiting.");
    }

    @Override 
    public void returnCard() {
        System.out.println("Returning card...");
    }
}
