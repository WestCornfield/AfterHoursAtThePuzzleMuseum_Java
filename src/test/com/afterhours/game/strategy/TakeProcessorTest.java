package com.afterhours.game.strategy;

import com.afterhours.game.inventory.Item;
import com.afterhours.game.player.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        assertEquals(testValue, "You have taken the lighter");
        assertTrue(player.getInventory().getInventory().contains(Item.LIGHTER));

        testValue = testObj.processAction(player, takeLostBox);
        assertEquals(testValue, "You can't take the lost box");
        assertFalse(player.getInventory().getInventory().contains(Item.LOST_BOX));
    }
}
