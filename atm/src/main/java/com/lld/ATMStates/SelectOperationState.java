package com.lld.ATMStates;

import com.lld.ATM;
import com.lld.Card;
import com.lld.TransactionType;

public class SelectOperationState extends ATMState {
    
    public SelectOperationState() {
        showOperations();
    }

    @Override 
    public void selectOperation(ATM atm, Card card, TransactionType transactionType) {
        switch(transactionType) {
            case CASH_WITHDRAWAL:
                atm.setCurrentATMState(new CashWithdrawlState());
                break;
            case CHECK_BALANCE:
                atm.setCurrentATMState(new CheckBalanceState());
                break;
            default:
                System.out.println("Invalid operation selected.");
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

    private void showOperations() {
        System.out.println("Please select an operation:");
        TransactionType.showAllTransactionTypes();
    }
}
