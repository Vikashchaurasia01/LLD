package com.lld;

import java.util.ArrayList;
import java.util.List;

import com.lld.VendingStates.States;
import com.lld.VendingStates.impl.IdleState;


public class VendingMachine {

    private States VendingMachineState;
    private List<Coin> coinList;
    private Inventory inventory;

    public VendingMachine() {
        this.VendingMachineState = new IdleState();
        this.coinList = new ArrayList<>();
        this.inventory = new Inventory(10);
    }

    public States getVendingMachineState() {
        return VendingMachineState;
    }

    public void setVendingMachineState(States vendingMachineState) {
        this.VendingMachineState = vendingMachineState;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public List<Coin> getCoinList() {
        return coinList;
    }

    public void setCoinList(List<Coin> coinList) {
        this.coinList = coinList;
    }
    
}
