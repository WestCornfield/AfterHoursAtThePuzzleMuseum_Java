package com.afterhours.game.inventory;

import com.afterhours.game.player.Player;
import com.afterhours.game.strategy.OpenProcessor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemTest {
    Item testObj;
    OpenProcessor openProcessor = new OpenProcessor();

    @Test
    public void testOpenUpdatesDescriptionText() {
        testObj = Item.LOST_BOX;

        Player player = new Player();
        String[] input = "open lost box".split(" ");

        openProcessor.processAction(player, input);

        assertTrue(testObj.isOpen());

        assertEquals(ItemConstants.LOST_BOX_DESCRIPTION_TEXT + "\nIt is currently open.", testObj.getDescription());
    }
}
