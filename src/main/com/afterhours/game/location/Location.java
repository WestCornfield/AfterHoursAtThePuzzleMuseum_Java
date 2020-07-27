package com.afterhours.game.location;

import java.util.ArrayList;
import java.util.List;

import com.afterhours.game.inventory.Item;

public enum Location {
    LOBBY(LocationConstants.LOBBY_DESCRIPTION_TEXT, "In the distance, you see the lobby", 0, 0, LocationItemLists.lobbyItemsList),
    MAZE("You find yourself in the Maze Exhibit", "In the distance, you see the maze room",-1, 0, LocationItemLists.mazeItemsList),
    KEYHOLE_NEWSPAPER(LocationConstants.KEYHOLE_NEWSPAPER_DESCRIPTION_TEXT, "In the distance, you see the keyhole newspaper exhibit room", 0, 1, LocationItemLists.keyholeNewspaperItemsList),
    LABYRINTH("You find yourself in the Labyrinth Exhibit", "In the distance, you see the labyrinth room",1, 0, new ArrayList<>());

    private String description;
    private String outsideDescription;
    private int x;
    private int y;
    private List<Item> itemsList;

    Location(String description, String outsideDescription, int x, int y, List<Item> itemsList) {
        this.description = description;
        this.outsideDescription = outsideDescription;
        this.x = x;
        this.y = y;
        this.itemsList = itemsList;
    }

    public String getDescription() {
        return description;
    }

    public String getOutsideDescription() {
        return outsideDescription;
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
