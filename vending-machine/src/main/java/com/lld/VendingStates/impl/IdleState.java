package com.lld.VendingStates.impl;

import java.util.ArrayList;
import java.util.List;

import com.lld.Coin;
import com.lld.Item;
import com.lld.VendingMachine;
import com.lld.VendingStates.States;

public class IdleState implements States {

    public IdleState() {
        System.out.println("Vending Machine is currently in Idle State. Please click on Insert Coin button to start the process.");
    }

    public IdleState(VendingMachine machine) {
        System.out.println("Vending Machine is currently in Idle state");
        machine.setCoinList(new ArrayList<>());
    }

    @Override
    public void clickOnInsertCoinButton(VendingMachine machine) throws Exception {
        machine.setVendingMachineState(new HasMoneyState());
    }

    @Override
    public void clickOnstartProductSelectionButton(VendingMachine machine) throws Exception {
        throw new Exception("First you need to click on insert coin button");
    }

    @Override
    public void insertCoin(VendingMachine machine, Coin coin) throws Exception {
        throw new Exception("You cannot insert coin in idle state");
    }

    @Override
    public void chooseProduct(VendingMachine machine, int codeNumber) throws Exception {
        throw new Exception("You cannot choose product in idle state");
    }

    @Override
    public int getChange(int returnChangeMoney) throws Exception {
        throw new Exception("You cannot get change in idle in idle state");
    }

    @Override
    public Item dispenseProduct(VendingMachine machine, int codeNumber) throws Exception {
        throw new Exception("Product cannot be dispensed in idle state");
    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine machine) throws Exception {
        throw new Exception("You cannot collect coin from vending machine in idle state");
    }

    @Override
    public void updateInventory(VendingMachine machine, Item item, int codeNumber) throws Exception {
        machine.getInventory().addItem(item, codeNumber);
    }
    
}
