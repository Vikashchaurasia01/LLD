package com.lld.ATMStates;

import com.lld.ATM;
import com.lld.Card;

public class HasCardState extends ATMState {
    
    public HasCardState() {
        System.out.println("Please enter your PIN.");
    }

    @Override 
    public void authenticatePin(ATM atm, Card card, int pin) {
        boolean isCorrectedPin = card.isCorrectPinEntered(pin);

        if (isCorrectedPin) {
            atm.setCurrentATMState(new SelectOperationState());
            System.out.println("PIN authenticated successfully.");
        } else {
            System.out.println("Invalid PIN. Please try again.");
            exit(atm);
        }
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
