package com.lld.ATMStates;

import com.lld.ATM;
import com.lld.Card;

public class IdleState extends ATMState {
    
    @Override
    public void insertCard(ATM atm, Card card) {
        atm.setCurrentATMState(new HasCardState());
        System.out.println("Card inserted.");
    }
    
}
