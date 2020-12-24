package com.afterhours.game.location;

import com.afterhours.game.inventory.Item;

import java.util.ArrayList;
import java.util.Arrays;

public class LocationItemLists {
    public static ArrayList<Item> lobbyItemsList = new ArrayList<>(Arrays.asList(new Item[] {Item.LIGHTER, Item.LOST_BOX, Item.POSTER}));
    public static ArrayList<Item> mazeItemsList = new ArrayList<>(Arrays.asList(new Item[] {Item.MAZE, Item.MAZE_WALL}));
    public static ArrayList<Item> keyholeNewspaperItemsList = new ArrayList<>(Arrays.asList(new Item[] {Item.DOME, Item.BRASS_KEY, Item.DOOR, Item.KEYHOLE, Item.NAIL_FILE, Item.PLAQUE, Item.TABLE}));
}
