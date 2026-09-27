package com.lld.AmountWithdrawl;

import com.lld.ATM;

public class FiveHunderedCashWithdrawlProcessor extends CashWithdrawProcess {

    public FiveHunderedCashWithdrawlProcessor(CashWithdrawProcess nextCashWithdrawProcess) {
        super(nextCashWithdrawProcess);
    }

    @Override
    public void withdraw(ATM atm, int amount) {

        int required = amount / 500;
        int balance = amount % 500;

        if(required <= atm.getNoOfFiveHunderedNotes()) {
            atm.deductFiveHunderedNotes(required);
        } else if (required > atm.getNoOfFiveHunderedNotes()) {
            atm.deductFiveHunderedNotes(atm.getNoOfFiveHunderedNotes());

            balance += (required - atm.getNoOfFiveHunderedNotes()) * 500;
        }

        if(balance != 0) {
            super.withdraw(atm, balance);
        }
    }
    
}
