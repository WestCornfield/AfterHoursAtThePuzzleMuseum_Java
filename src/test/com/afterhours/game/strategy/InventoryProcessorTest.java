package com.afterhours.game.strategy;

import com.afterhours.game.inventory.Item;
import com.afterhours.game.player.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InventoryProcessorTest {
    InventoryProcessor testObj = new InventoryProcessor();

    @Test
    public void testInventoryProcessor() {
        Player player = new Player();
        String testValue = testObj.processAction(player, "inventory");
        assertEquals(testValue, "In your possessions, you have a badge, a nightstick, and the lint in your pockets.");

        player.pickup(Item.LIGHTER);
        testValue = testObj.processAction(player, "inventory");
        assertEquals(testValue, "In your possessions, you have a badge, a nightstick, a lighter, and the lint in your pockets.");

    }
}
