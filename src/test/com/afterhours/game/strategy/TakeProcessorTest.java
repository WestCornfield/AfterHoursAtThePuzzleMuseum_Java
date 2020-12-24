package com.afterhours.game.strategy;

import com.afterhours.game.inventory.Item;
import com.afterhours.game.location.Location;
import com.afterhours.game.player.Player;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TakeProcessorTest {
    TakeProcessor testObj = new TakeProcessor();

    @Test
    public void takeProcessorTest() {
        Player player = new Player();
        ArrayList<Item> lobbyItemsList = new ArrayList<Item>();
        lobbyItemsList.add(Item.LIGHTER);
        lobbyItemsList.add(Item.LOST_BOX);
        lobbyItemsList.add(Item.POSTER);

        Location.LOBBY.setItemsList(lobbyItemsList);

        String[] take = {"take"};
        String[] takeLighter = {"take", "lighter"};
        String[] takeLostBox = {"take", "lost", "box"};
        String[] takeMagazine = {"take", "magazine"};

        String testValue = testObj.processAction(player, take);
        assertEquals(testValue, "Take what?");

        testValue = testObj.processAction(player, takeLighter);
        assertEquals(testValue, "You have taken the lighter");
        assertTrue(player.getInventory().getInventoryContents().contains(Item.LIGHTER));

        testValue = testObj.processAction(player, takeLostBox);
        assertEquals(testValue, "You can't take the lost box");
        assertFalse(player.getInventory().getInventoryContents().contains(Item.LOST_BOX));

        testValue = testObj.processAction(player, takeMagazine);
        assertEquals(testValue, "You can't reach the magazine from here");
        assertFalse(player.getInventory().getInventoryContents().contains(Item.MAGAZINE));
    }

    @Test
    public void takeProcessorTestWithBoxContents() {
        Player player = new Player();
        ArrayList<Item> lobbyItemsList = new ArrayList<Item>();
        lobbyItemsList.add(Item.LIGHTER);
        lobbyItemsList.add(Item.LOST_BOX);
        lobbyItemsList.add(Item.POSTER);

        Location.LOBBY.setItemsList(lobbyItemsList);

        String[] take = {"take"};
        String[] takeLighter = {"take", "lighter"};
        String[] takeLostBox = {"take", "lost", "box"};
        String[] takePoster = {"take", "poster"};
        String[] openLostBox = {"take", "lost", "box"};
        String[] takeMagazine = {"take", "magazine"};

        String testValue = testObj.processAction(player, take);
        assertEquals("Take what?", testValue);

        assertTrue(Location.LOBBY.getItemsList().contains(Item.LIGHTER));

        testValue = testObj.processAction(player, takeLighter);
        assertEquals("You have taken the lighter", testValue);
        assertTrue(player.getInventory().getInventoryContents().contains(Item.LIGHTER));

        assertFalse(Location.LOBBY.getItemsList().contains(Item.LIGHTER));

        testValue = testObj.processAction(player, takeLostBox);
        assertEquals("You can't take the lost box", testValue);
        assertFalse(player.getInventory().getInventoryContents().contains(Item.LOST_BOX));

        testValue = testObj.processAction(player, takePoster);
        assertEquals("You can't take the poster", testValue);
        assertFalse(player.getInventory().getInventoryContents().contains(Item.POSTER));

        OpenProcessor openProcessor = new OpenProcessor();
        testValue = openProcessor.processAction(player, openLostBox);
        assertEquals("You have opened the lost box", testValue);

        testValue = testObj.processAction(player, takePoster);
        assertEquals("You have taken the poster", testValue);
        assertTrue(player.getInventory().getInventoryContents().contains(Item.POSTER));

        testValue = testObj.processAction(player, takeMagazine);
        assertEquals("You can't reach the magazine from here", testValue);
        assertFalse(player.getInventory().getInventoryContents().contains(Item.MAGAZINE));
    }
}
