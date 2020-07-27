package com.afterhours.game.inventory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Inventory {
    List<Item> itemsList;

    public Inventory(Item... itemsList) {
        this.itemsList = new ArrayList<>();
        for (Item item: itemsList) {
            this.itemsList.add(item);
        }
    }

    public List<Item> getInventory() {
        return itemsList;
    }

    public void addToInventory(Item item) {
        itemsList.add(item);
    }
}
