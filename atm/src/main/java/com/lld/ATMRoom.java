package com.lld;

public class ATMRoom {
    ATM atm;
    User user;

    public static void main(String[] args) {
        ATMRoom atmRoom = new ATMRoom();
        atmRoom.initialize();
        
        atmRoom.atm.printCurrentATMStatus();
        atmRoom.atm.getCurrentATMState().insertCard(atmRoom.atm, atmRoom.atm.card);
        atmRoom.atm.getCurrentATMState().authenticatePin(atmRoom.atm, atmRoom.atm.card, 112211);
        atmRoom.atm.getCurrentATMState().selectOperation(atmRoom.atm, atmRoom.atm.card, TransactionType.CASH_WITHDRAWAL);
        atmRoom.atm.getCurrentATMState().cashWithdrawal(atmRoom.atm, atmRoom.atm.card, 2800);
        atmRoom.atm.printCurrentATMStatus();
    }

    private void initialize() {
        atm = ATM.getATMObject();
        atm.setAtmBalance(3500, 1, 2, 2, 1);

        this.user = createUser();
        atm.card = this.user.getCard();
    }

    private User createUser() {
        User user = new User();
        user.setCard(createCard());
        return user;
    }

    private Card createCard() {
        Card card = new Card();
        card.setBankAccount(createBankAccount());
        return card;

    }

    private UserBankAccount createBankAccount() {
        UserBankAccount bankAccount = new UserBankAccount();
        bankAccount.balance = 3000;
        return bankAccount;
    }
}
