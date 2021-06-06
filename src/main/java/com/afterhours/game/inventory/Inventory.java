package com.afterhours.game.inventory;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    List<Item> itemsList;

    public Inventory(Item... itemsList) {
        this.itemsList = new ArrayList<>();
        for (Item item: itemsList) {
            this.itemsList.add(item);
        }
    }

    public List<Item> getInventoryContents() {
        return itemsList;
    }

    public void addToInventory(Item item) {
        itemsList.add(item);
    }

    public void removeFromInventory(Item item) {
        itemsList.remove(item);
    }
}
