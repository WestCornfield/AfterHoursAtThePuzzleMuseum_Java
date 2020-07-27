package com.afterhours.game.strategy;

import com.afterhours.game.location.LocationConstants;
import com.afterhours.game.player.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ExamineProcessorTest {
    ExamineProcessor testObj = new ExamineProcessor();
    Player player = new Player();

    @Test
    public void testProcessActionLook() {
        String testValue = testObj.processAction(player, "look");
        assertEquals(testValue, LocationConstants.LOBBY_DESCRIPTION_TEXT);
    }

    @Test
    public void testProcessActionLookAtBadge() {
        String[] input = {"look", "at", "badge"};
        String testValue = testObj.processAction(player, input);
        assertEquals(testValue, "Your trusty security badge");
    }

    @Test
    public void testProcessActionLookAtNightstick() {
        String[] input = {"look", "at", "nightstick"};
        String testValue = testObj.processAction(player, input);
        assertEquals(testValue, "It's a nightstick.");
    }

    @Test
    public void testProcessActionLookAtNonExistentObject() {
        String[] input = {"look", "at", "flargle"};
        String testValue = testObj.processAction(player, input);
        assertEquals(testValue, "Look at what?");
    }

    @Test
    public void testProcessActionLookAtObjectOutsideLobby() {
        String[] input = {"look", "at", "maze"};
        String testValue = testObj.processAction(player, input);
        assertEquals(testValue, "You can't see that from here");

        player.move(-1, 0); //move to Maze
        testValue = testObj.processAction(player, input);
        assertEquals(testValue, "It's a Labyrinth");
    }
}
