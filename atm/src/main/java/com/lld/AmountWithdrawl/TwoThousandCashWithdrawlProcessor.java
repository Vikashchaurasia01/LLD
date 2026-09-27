package com.lld.AmountWithdrawl;

import com.lld.ATM;

public class TwoThousandCashWithdrawlProcessor extends CashWithdrawProcess {

    public TwoThousandCashWithdrawlProcessor(CashWithdrawProcess nextCashWithdrawProcess) {
        super(nextCashWithdrawProcess);
    }

    @Override
    public void withdraw(ATM atm, int amount) {

        int required = amount / 2000;
        int balance = amount % 2000;

        if(required <= atm.getNoOfTwoThousandNotes()) {
            atm.deductTwoThousandNotes(required);
        } else if (required > atm.getNoOfTwoThousandNotes()) {
            atm.deductTwoThousandNotes(atm.getNoOfTwoThousandNotes());

            balance += (required - atm.getNoOfTwoThousandNotes()) * 2000;
        }

        if(balance != 0) {
            super.withdraw(atm, balance);
        }
    }
    
}
