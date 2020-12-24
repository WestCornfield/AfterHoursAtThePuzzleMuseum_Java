package com.afterhours.game.strategy;

import com.afterhours.game.inventory.Item;
import com.afterhours.game.player.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CloseProcessorTest {
    CloseProcessor testObj = new CloseProcessor();

    @Test
    public void closeProcessorTest() {
        Item.LOST_BOX.open();

        Player player = new Player();
        String[] open = {"close"};
        String[] openLighter = {"close", "lighter"};
        String[] openLostBox = {"close", "lost", "box"};

        String testValue = testObj.processAction(player, open);
        assertEquals(testValue, "Close what?");

        testValue = testObj.processAction(player, openLighter);
        assertEquals("You can't close the lighter", testValue);

        assertTrue(Item.LOST_BOX.isOpen());

        testValue = testObj.processAction(player, openLostBox);
        assertEquals("You have closed the lost box", testValue);

        assertFalse(Item.LOST_BOX.isOpen());

        testValue = testObj.processAction(player, openLostBox);
        assertEquals("The lost box is already closed", testValue);

    }
}
