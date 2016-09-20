package com.helibrothers.dico.domain;

/**
 * Created by LeeDaebeom-Mac on 2016. 9. 21..
 */
public class CartItem {
    private Item item;
    private int amount;

    public CartItem(Item item, int amount) {
        this.item = item;
        this.amount = amount;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void addAmount(Integer amount) {
        this.amount += amount;
    }
}
