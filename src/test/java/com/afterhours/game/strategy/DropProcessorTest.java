package com.afterhours.game.strategy;

import com.afterhours.game.player.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DropProcessorTest {
    DropProcessor testObj = new DropProcessor();
    TakeProcessor takeProcessor = new TakeProcessor();

    @Test
    public void dropProcessorTest() {
        Player player = new Player();
        String[] drop = {"drop"};
        String[] dropNailFile = {"drop", "nail", "file"};
        String[] dropBadge = {"drop", "badge"};
        String[] takeBadge = {"take", "badge"};

        String testValue = testObj.processAction(player, drop);
        assertEquals(testValue, "Drop what?");

        testValue = testObj.processAction(player, dropNailFile);
        assertEquals("You can't drop the nail file when you don't have the nail file", testValue);

        testValue = testObj.processAction(player, dropBadge);
        assertEquals("You have dropped the badge", testValue);

        testValue =  takeProcessor.processAction(player, takeBadge);
        assertEquals("You have taken the badge", testValue);
    }
}
