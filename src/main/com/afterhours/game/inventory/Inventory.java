package com.afterhours.game.inventory;

import java.util.Arrays;
import java.util.List;

public class Inventory {
    List<Item> itemsList;

    public Inventory(Item... itemsList) {
        this.itemsList = Arrays.asList(itemsList);
    }

    public List<Item> getInventory() {
        return itemsList;
    }
}
