package com.afterhours.game.strategy;

import com.afterhours.game.location.LocationConstants;
import com.afterhours.game.player.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovementProcessorTest {
    MovementProcessor testObj = new MovementProcessor();

    @Test
    public void movementProcessorTest() {
        Player player = new Player();
        String[] goNorth = {"go", "north"};
        String[] goSouth = {"go", "south"};
        String[] goEast = {"move", "east"};
        String[] goWest = {"west"};
        String[] go = {"go"};

        String testValue = testObj.processAction(player, goNorth);
        assertEquals(testValue, LocationConstants.KEYHOLE_NEWSPAPER_DESCRIPTION_TEXT);

        testValue = testObj.processAction(player, goNorth);
        assertEquals(testValue, "You can't go that way.");

        testValue = testObj.processAction(player, goSouth);
        assertEquals(testValue, LocationConstants.LOBBY_DESCRIPTION_TEXT);

        testValue = testObj.processAction(player, goSouth);
        assertEquals(testValue, "You can't go that way.");

        testValue = testObj.processAction(player, goEast);
        assertEquals(testValue, "You find yourself in the Labyrinth Exhibit");

        testValue = testObj.processAction(player, goEast);
        assertEquals(testValue, "You can't go that way.");

        testValue = testObj.processAction(player, goWest);
        assertEquals(testValue, LocationConstants.LOBBY_DESCRIPTION_TEXT);

        testValue = testObj.processAction(player, goWest);
        assertEquals(testValue, "You find yourself in the Maze Exhibit");

        testValue = testObj.processAction(player, goWest);
        assertEquals(testValue, "You can't go that way.");

        testValue = testObj.processAction(player, go);
        assertEquals(testValue, "Move where?");
    }

}
