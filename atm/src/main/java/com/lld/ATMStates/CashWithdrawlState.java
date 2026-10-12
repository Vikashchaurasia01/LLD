package com.lld.ATMStates;

import com.lld.ATM;
import com.lld.Card;
import com.lld.AmountWithdrawl.CashWithdrawProcess;
import com.lld.AmountWithdrawl.FiveHunderedCashWithdrawlProcessor;
import com.lld.AmountWithdrawl.OneHunderedCashWithdrawlProcessor;
import com.lld.AmountWithdrawl.TwoHunderedCashWithdrawlProcessor;
import com.lld.AmountWithdrawl.TwoThousandCashWithdrawlProcessor;

public class CashWithdrawlState extends ATMState {
    public CashWithdrawlState() {
        System.out.println("ATM is in Cash Withdrawl State.");
    }

    @Override 
    public void cashWithdrawal(ATM atm, Card card, int amount) {
        if(atm.getATMBalance() < amount) {
            System.out.println("Insufficient balance in ATM.");
            exit(atm);
        } else if(card.getBalance() < amount) {
            System.out.println("Insufficient balance in card.");
            exit(atm);
        } else {
            atm.deductBalance(amount);
            card.deductBankBalance(amount);
            
            CashWithdrawProcess cashWithdrawlProcess = 
                    new TwoThousandCashWithdrawlProcessor(new FiveHunderedCashWithdrawlProcessor(new TwoHunderedCashWithdrawlProcessor(new OneHunderedCashWithdrawlProcessor(null))));

            cashWithdrawlProcess.withdraw(atm, amount);

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
