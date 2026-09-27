package com.lld.AmountWithdrawl;

import com.lld.ATM;

public class OneHunderedCashWithdrawlProcessor extends CashWithdrawProcess {

    public OneHunderedCashWithdrawlProcessor(CashWithdrawProcess nextCashWithdrawProcess) {
        super(nextCashWithdrawProcess);
    }

    @Override
    public void withdraw(ATM atm, int amount) {

        int required = amount / 100;
        int balance = amount % 100;

        if(required <= atm.getNoOfOneHunderedNotes()) {
            atm.deductOneHunderedNotes(required);
        } else if (required > atm.getNoOfOneHunderedNotes()) {
            atm.deductOneHunderedNotes(atm.getNoOfOneHunderedNotes());

            balance += (required - atm.getNoOfOneHunderedNotes()) * 100;
        }

        if(balance != 0) {
            System.out.println("ATM does not have enough cash to dispense the requested amount.");
        }
    }

    
    
}
