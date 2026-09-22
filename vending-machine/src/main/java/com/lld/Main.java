package com.lld;

import com.lld.VendingStates.States;

public class Main {
    public static void main(String[] args) {
        
        VendingMachine vendingMachine = new VendingMachine();

        try{
            System.out.println("|");
            System.out.println("Filling up the inventory");
            System.out.println("|");

            fillupInventory(vendingMachine);
            displayInventory(vendingMachine);

            System.out.println("|");
            System.out.println("Clicking on insert coin button");
            System.out.println("|");

            States vendingState = vendingMachine.getVendingMachineState();
            vendingState.clickOnInsertCoinButton(vendingMachine);

            vendingState = vendingMachine.getVendingMachineState();
            vendingState.insertCoin(vendingMachine, Coin.NICKEL);
            vendingState.insertCoin(vendingMachine, Coin.QUARTER);

            System.out.println("|");
            System.out.println("Click on Product selection button");
            System.out.println("|");
            vendingState.clickOnstartProductSelectionButton(vendingMachine);

            vendingState = vendingMachine.getVendingMachineState();
            vendingState.chooseProduct(vendingMachine, 102);

            displayInventory(vendingMachine);
        } catch (Exception e) {
            displayInventory(vendingMachine);
            // e.printStackTrace();
        }
    }

	private static void displayInventory(VendingMachine vendingMachine) {
		ItemShelf[] slots = vendingMachine.getInventory().getInventory();

        for(int i=0; i<slots.length; i++) {
            System.out.println("CodeNumber: " + slots[i].getCode() +
                    " Item: " + slots[i].getItem().getType().name() +
                    " Price: " + slots[i].getItem().getPrice() +
                    " isAvailable: " + !slots[i].isSoldOut());
        }
	}

	private static void fillupInventory(VendingMachine vendingMachine) {
		ItemShelf[] slots = vendingMachine.getInventory().getInventory();

        for(int i=0; i<slots.length; i++) {
            Item newItem = new Item();

            if(i >= 0 && i < 3) {
                newItem.setType(ItemType.COKE);
                newItem.setPrice(12);
            } else if(i >= 3 && i < 5) {
                newItem.setType(ItemType.PEPSI);
                newItem.setPrice(9);
            } else if(i >= 5 && i < 7) {
                newItem.setType(ItemType.JUICE);
                newItem.setPrice(15);
            } else if(i >= 7 && i < 10) {
                newItem.setType(ItemType.SODA);
                newItem.setPrice(7);
            }

            slots[i].setItem(newItem);
            slots[i].setSoldOut(false);
        }
	}
}