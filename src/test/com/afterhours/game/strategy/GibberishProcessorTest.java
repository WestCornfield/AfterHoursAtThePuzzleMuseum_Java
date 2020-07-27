package com.afterhours.game.strategy;

import com.afterhours.game.player.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GibberishProcessorTest {
    GibberishProcessor testObj = new GibberishProcessor();
    Player player = new Player();

    @Test
    public void testGibberishProcessor() {
        String[] input = {"flarge", "skarple", "curd"};
        String testValue = testObj.processAction(player, input);
        assertEquals(testValue, "Pardon?");
    }
}
