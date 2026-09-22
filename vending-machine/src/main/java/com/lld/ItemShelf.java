package com.lld;

public class ItemShelf {

    public int code;
    public Item item;
    boolean soldOut;

    public void setCode(int code) {
        this.code = code;
    }

    public void setSoldOut(boolean soldOut) {
        this.soldOut = soldOut;
    }

    public boolean isSoldOut() {
        return soldOut;
    }

    public int getCode() {
        return code;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
    
}
