package com.afterhours.game.inventory;

import com.afterhours.game.player.Player;
import com.afterhours.game.strategy.CloseProcessor;
import com.afterhours.game.strategy.OpenProcessor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ItemTest {
    Item testObj;
    OpenProcessor openProcessor = new OpenProcessor();
    CloseProcessor closeProcessor = new CloseProcessor();

    @Test
    public void testOpenUpdatesDescriptionText() {
        testObj = Item.LOST_BOX;

        Player player = new Player();
        String[] input = "open lost box".split(" ");

        openProcessor.processAction(player, input);

        assertTrue(testObj.isOpen());

        assertEquals(ItemConstants.LOST_BOX_DESCRIPTION_TEXT + "\n\nIt is currently open. Inside you find a poster,  and... no, that's it.", testObj.getDescription());

        closeProcessor.processAction(player, input);

        assertFalse(testObj.isOpen());

        assertEquals(ItemConstants.LOST_BOX_DESCRIPTION_TEXT + "\n\nIt is currently closed.", testObj.getDescription());

    }
}
