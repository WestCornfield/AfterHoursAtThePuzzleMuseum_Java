package com.afterhours.game.strategy;

import com.afterhours.game.inventory.Item;
import com.afterhours.game.player.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuitProcessorTest {
    QuitProcessor testObj = new QuitProcessor();

    @Test
    public void quitProcessorTest() {
        String testValue = "";

        Player player = new Player();
        String[] quit = {"quit"};

        testValue = testObj.processAction(player, quit);
        assertEquals("Goodbye!", testValue);
    }
}
