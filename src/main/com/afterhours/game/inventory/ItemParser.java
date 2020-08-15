package com.afterhours.game.inventory;

public class ItemParser {
    public Item parseItem(String object) {
        Item itemToReturn;
        for (Item item : Item.values()) {
            for (String synonym : item.getSynonyms()) {
                if (synonym.equals(object)) {
                    return item;
                }
            }
        }
        return Item.NOT_FOUND;
    }
}
