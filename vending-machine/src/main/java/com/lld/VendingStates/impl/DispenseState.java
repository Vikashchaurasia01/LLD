package com.lld.VendingStates.impl;

import java.util.List;

import com.lld.Coin;
import com.lld.Item;
import com.lld.VendingMachine;
import com.lld.VendingStates.States;

public class DispenseState implements States {

    DispenseState(VendingMachine machine, int codeNumber) throws Exception {
        System.out.println("Currently vending machine is in despense state");
        dispenseProduct(machine, codeNumber);
    }

	@Override
	public void clickOnInsertCoinButton(VendingMachine machine) throws Exception {
        throw new Exception("insert coin button can not clicked on Dispense state");
	}

	@Override
	public void clickOnstartProductSelectionButton(VendingMachine machine) throws Exception {
        throw new Exception("Product selection can not clicked on Dispense state");
	}

	@Override
	public void insertCoin(VendingMachine machine, Coin coin) throws Exception {
        throw new Exception("Coin can not inserted on Dispense state");
	}

	@Override
	public void chooseProduct(VendingMachine machine, int codeNumber) throws Exception {
        throw new Exception("Product can not be choosen in Dispense state");
	}

	@Override
	public int getChange(int returnChangeMoney) throws Exception {
        throw new Exception("change can not returned in Dispense state");
	}

	@Override
	public Item dispenseProduct(VendingMachine machine, int codeNumber) throws Exception {
		System.out.println("Product has been dispensed");
        Item item = machine.getInventory().getItem(codeNumber);
        machine.getInventory().updateSoldOutitem(codeNumber);
        machine.setVendingMachineState(new IdleState(machine));
        return item;
	}

	@Override
	public List<Coin> refundFullMoney(VendingMachine machine) throws Exception {
        throw new Exception("refund cannot be happened in Dispense state");
	}

	@Override
	public void updateInventory(VendingMachine machine, Item item, int codeNumber) throws Exception {
        throw new Exception("inventory can not be updated in Dispense state");
	}
    
}
