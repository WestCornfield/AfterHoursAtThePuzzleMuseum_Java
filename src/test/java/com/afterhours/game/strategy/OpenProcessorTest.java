package com.afterhours.game.strategy;

import com.afterhours.game.inventory.Item;
import com.afterhours.game.player.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OpenProcessorTest {
    OpenProcessor testObj = new OpenProcessor();

    @Test
    public void openProcessorTest() {
        Item.LOST_BOX.close();

        Player player = new Player();
        String[] open = {"open"};
        String[] openLighter = {"open", "lighter"};
        String[] openLostBox = {"open", "lost", "box"};

        String testValue = testObj.processAction(player, open);
        assertEquals(testValue, "Open what?");

        testValue = testObj.processAction(player, openLighter);
        assertEquals("You can't open the lighter", testValue);

        assertFalse(Item.LOST_BOX.isOpen());

        testValue = testObj.processAction(player, openLostBox);
        assertEquals("You have opened the lost box", testValue);

        assertTrue(Item.LOST_BOX.isOpen());

        testValue = testObj.processAction(player, openLostBox);
        assertEquals("The lost box is already open", testValue);
    }
}
