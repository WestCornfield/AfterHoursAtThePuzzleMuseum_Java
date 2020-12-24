package com.afterhours.game.strategy;

import com.afterhours.game.inventory.Item;
import com.afterhours.game.player.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OpenProcessorTest {
    OpenProcessor testObj = new OpenProcessor();

    @Test
    public void openProcessorTest() {
        Player player = new Player();
        String[] open = {"open"};
        String[] openLighter = {"open", "lighter"};
        String[] openLostBox = {"open", "lost", "box"};

        String testValue = testObj.processAction(player, open);
        assertEquals(testValue, "Open what?");

        testValue = testObj.processAction(player, openLighter);
        assertEquals(testValue, "You can't open the lighter");

        assertTrue(!Item.LOST_BOX.isOpen());

        testValue = testObj.processAction(player, openLostBox);
        assertEquals(testValue, "You have opened the lost box");

        assertTrue(Item.LOST_BOX.isOpen());
    }
}
