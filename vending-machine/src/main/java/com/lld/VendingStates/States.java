package com.lld.VendingStates;

import java.util.List;

import com.lld.Coin;
import com.lld.Item;
import com.lld.VendingMachine;

public interface States {
    
    public void clickOnInsertCoinButton(VendingMachine machine) throws Exception;

    public void clickOnstartProductSelectionButton(VendingMachine machine) throws Exception;

    public void insertCoin(VendingMachine machine, Coin coin) throws Exception;

    public void chooseProduct(VendingMachine machine, int codeNumber) throws Exception;

    public int getChange(int returnChangeMoney) throws Exception;

    public Item dispenseProduct(VendingMachine machine, int codeNumber) throws Exception;

    public List<Coin> refundFullMoney(VendingMachine machine) throws Exception;

    public void updateInventory(VendingMachine machine, Item item, int codeNumber) throws Exception;

}
