package com.afterhours.game.strategy;

import com.afterhours.game.inventory.Item;
import com.afterhours.game.player.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TakeProcessorTest {
    TakeProcessor testObj = new TakeProcessor();

    @Test
    public void takeProcessorTest() {
        Player player = new Player();
        String[] take = {"take"};
        String[] takeLighter = {"take", "lighter"};
        String[] takeLostBox = {"take", "lost", "box"};

        String testValue = testObj.processAction(player, take);
        assertEquals(testValue, "Take what?");

        testValue = testObj.processAction(player, takeLighter);
        assertEquals("You have taken the lighter", testValue);
        assertTrue(player.getInventory().getInventory().contains(Item.LIGHTER));

        testValue = testObj.processAction(player, takeLostBox);
        assertEquals("You can't take the lost box", testValue);
        assertFalse(player.getInventory().getInventory().contains(Item.LOST_BOX));
    }
}
