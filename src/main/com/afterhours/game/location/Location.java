package com.afterhours.game.location;

import java.util.ArrayList;
import java.util.List;

import com.afterhours.game.inventory.Item;

public enum Location {
    LOBBY(LocationConstants.LOBBY_DESCRIPTION_TEXT, 0, 0, LocationItemLists.lobbyItemsList),
    MAZE("You find yourself in the Maze Exhibit", -1, 0, LocationItemLists.mazeItemsList),
    KEYHOLE_NEWSPAPER(LocationConstants.KEYHOLE_NEWSPAPER_DESCRIPTION_TEXT, 0, 1, LocationItemLists.keyholeNewspaperItemsList),
    LABYRINTH("You find yourself in the Labyrinth Exhibit", 1, 0, new ArrayList<>());

    private String description;
    private int x;
    private int y;
    private List<Item> itemsList;

    Location(String description, int x, int y, List<Item> itemsList) {
        this.description = description;
        this.x = x;
        this.y = y;
        this.itemsList = itemsList;
    }

    public String getDescription() {
        return description;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public List<Item> getItemsList() {
        return itemsList;
    }
}
