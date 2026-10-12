package com.lld.AmountWithdrawl;

import com.lld.ATM;

public class TwoHunderedCashWithdrawlProcessor extends CashWithdrawProcess {

    public TwoHunderedCashWithdrawlProcessor(CashWithdrawProcess nextCashWithdrawProcess) {
        super(nextCashWithdrawProcess);
    }

    @Override
    public void withdraw(ATM atm, int amount) {

        int required = amount / 200;
        int balance = amount % 200;

        if(required <= atm.getNoOfFiveHunderedNotes()) {
            atm.deductTwoHunderedNotes(required);
        } else if (required > atm.getNoOfFiveHunderedNotes()) {
            atm.deductTwoHunderedNotes(atm.getNoOfFiveHunderedNotes());

            balance += (required - atm.getNoOfFiveHunderedNotes()) * 200;
        }

        if(balance != 0) {
            super.withdraw(atm, balance);
        }
    }
    
}
