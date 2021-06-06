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
        String[] close = {"close"};
        String[] closeLighter = {"close", "lighter"};
        String[] closeLostBox = {"close", "lost", "box"};

        String testValue = testObj.processAction(player, close);
        assertEquals(testValue, "Close what?");

        testValue = testObj.processAction(player, closeLighter);
        assertEquals("You can't close the lighter", testValue);

        assertTrue(Item.LOST_BOX.isOpen());

        testValue = testObj.processAction(player, closeLostBox);
        assertEquals("You have closed the lost box", testValue);

        assertFalse(Item.LOST_BOX.isOpen());

        testValue = testObj.processAction(player, closeLostBox);
        assertEquals("The lost box is already closed", testValue);
    }
}
