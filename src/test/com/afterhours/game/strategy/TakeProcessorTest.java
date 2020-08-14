package com.afterhours.game.strategy;

import com.afterhours.game.inventory.Item;
import com.afterhours.game.player.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TakeProcessorTest {
    TakeProcessor testObj = new TakeProcessor();

    @Test
    public void takeProcessorTest() {
        Player player = new Player();
        String[] take = {"take"};
        String[] takeLighter = {"take", "lighter"};

        String testValue = testObj.processAction(player, take);
        assertEquals(testValue, "Take what?");

        testValue = testObj.processAction(player, takeLighter);
        assertEquals(testValue, "You have taken the lighter");
        assertTrue(player.getInventory().getInventory().contains(Item.LIGHTER));
    }
}
