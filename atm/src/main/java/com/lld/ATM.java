package com.lld;

import com.lld.ATMStates.ATMState;
import com.lld.ATMStates.IdleState;

public class ATM {

    public static ATM atm = new ATM(); // eager initialization of singleton instance

    private ATMState currentATMState;

    private int atmBalance;
    int noOfTwoThousandNotes;
    int noOfFiveHunderedNotes;
    int noOfTwoHunderedNotes;
    int noOfOneHunderedNotes;

    public Card card;

    ATM() {
    }

    public void setCurrentATMState(ATMState currentATMState) {
        this.currentATMState = currentATMState;
    }

    public ATMState getCurrentATMState() {
        return this.currentATMState;
    }

    // public int getBalance() {
    //     return atmBalance;
    // }

    public int getATMBalance() {
        return atmBalance;
    }

    public void deductBalance(int amount) {
        atmBalance = atmBalance - amount;
    }

    public void deductTwoThousandNotes(int required) {
        noOfTwoThousandNotes -= required;
    }

    public int getNoOfTwoThousandNotes() {
        return noOfTwoThousandNotes;
    }

    public int getNoOfFiveHunderedNotes() {
        return noOfFiveHunderedNotes;
    }

    public int getNoOfOneHunderedNotes() {
        return noOfOneHunderedNotes;
    }

    public void deductFiveHunderedNotes(int required) {
        noOfFiveHunderedNotes -= required;
    }

    public void deductTwoHunderedNotes(int required) {
        noOfTwoHunderedNotes -= required;
    }

    public void deductOneHunderedNotes(int required) {
        noOfOneHunderedNotes -= required;
    }

    public void printCurrentATMStatus() {
        System.out.println("Balance: " + atmBalance);
        System.out.println("2kNotes: " + noOfTwoThousandNotes);
        System.out.println("500Notes: " + noOfFiveHunderedNotes);
        System.out.println("200Notes: " + noOfTwoHunderedNotes);
        System.out.println("100Notes: " + noOfOneHunderedNotes);
    }

    public static ATM getATMObject() {
        atm.setCurrentATMState(new IdleState());
        return atm;
    }

    public void setAtmBalance(int atmBalance, int noOfTwoThousandNotes, int noOfFiveHunderedNotes, int noOfTwoHunderedNotes, int noOfOneHunderedNotes) {
        this.atmBalance = atmBalance;
        this.noOfFiveHunderedNotes = noOfFiveHunderedNotes;
        this.noOfTwoHunderedNotes = noOfTwoHunderedNotes;
        this.noOfTwoThousandNotes = noOfTwoThousandNotes;
        this.noOfOneHunderedNotes = noOfOneHunderedNotes;
    }

}
