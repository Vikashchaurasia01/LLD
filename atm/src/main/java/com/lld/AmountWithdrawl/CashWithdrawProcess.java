package com.lld.AmountWithdrawl;

import com.lld.ATM;

public class CashWithdrawProcess {

    CashWithdrawProcess nextCashWithdrawProcess;

    CashWithdrawProcess(CashWithdrawProcess nextCashWithdrawProcess) {
        this.nextCashWithdrawProcess = nextCashWithdrawProcess;
    }

    public void withdraw(ATM atm, int amount) {
        if(nextCashWithdrawProcess != null) {
            nextCashWithdrawProcess.withdraw(atm, amount);
        }
    }
    
}
