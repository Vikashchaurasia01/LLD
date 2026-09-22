package com.lld;

public class Inventory {
    ItemShelf[] inventory = null;

    public Inventory(int size) {
        inventory = new ItemShelf[size];
        initilaEmptyInventory();
    }

    public ItemShelf[] getInventory(){
        return inventory;
    }

    public void setInventory(ItemShelf[] inventory) {
        this.inventory = inventory;
    }

    public void initilaEmptyInventory(){
        int startCode = 101;
        for(int i=0; i<inventory.length; i++) {
            ItemShelf space = new ItemShelf();
            space.setCode(startCode);
            space.setSoldOut(true);
            inventory[i] = space;
            startCode++;
        }
    }

    public void addItem(Item item, int codeNumber) throws Exception {
        for(ItemShelf itemShelf : inventory) {
            if(itemShelf.code == codeNumber) {
                if(itemShelf.isSoldOut()) {
                    itemShelf.item = item;
                    itemShelf.setSoldOut(false);
                } else 
                    throw new UnsupportedOperationException("Unimplemented method 'addItem'");
            }
        }
    }


    public Item getItem(int codeNumber) throws Exception {
        for(ItemShelf itemShelf : inventory) {
            if(itemShelf.code == codeNumber) {
                if(itemShelf.isSoldOut()) {
                    throw new Exception("Item already sold out");
                } else
                    return itemShelf.item;
            }
        }
        throw new Exception("Invalid code");
    }

    public void updateSoldOutitem(int codeNumber) {
        for(ItemShelf itemShelf : inventory) {
            if(itemShelf.code == codeNumber)
                itemShelf.setSoldOut(true);
        }
    }
}
