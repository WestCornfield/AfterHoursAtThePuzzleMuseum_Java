package com.afterhours.game.inventory;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemUtilsTest {
    @Test
    public void generateListOfItemsWorks() {
        List<Item> items = new ArrayList<>();
        items.add(Item.LOST_BOX);
        items.add(Item.MAGAZINE);
        items.add(Item.NAIL_FILE);

        String listOfItems = ItemUtils.generateListOfItems(items);

        assertEquals("a lost box, a magazine, a nail file, ", listOfItems);
    }
}
