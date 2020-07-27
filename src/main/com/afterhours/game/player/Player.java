package com.afterhours.game.player;

import com.afterhours.game.inventory.Inventory;
import com.afterhours.game.inventory.Item;
import com.afterhours.game.location.Location;

public class Player {
    private Inventory inventory;
    private Location location;

    public Player() {
        inventory = new Inventory(new Item[]{Item.BADGE, Item.NIGHTSTICK});
        location = Location.LOBBY;
    }

    public Location getLocation() {
        return location;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public String printInventory() {
        StringBuilder output = new StringBuilder();
        for (Item item : inventory.getInventory()) {
            output.append("a " + item.toString().toLowerCase() + ", ");
        }

        return "In your possessions, you have " + output + "and the lint in your pockets.";
    }

    public String move(int x, int y) {
        Location currentLocation = location;
        int newX = location.getX() + x;
        int newY = location.getY() + y;
        for (Location location : Location.values()) {
            if (location.getX() == newX && location.getY() == newY) {
                this.location = location;
                return location.getDescription();
            }
        }
        if (currentLocation == location) {
            return "You can't go that way.";
        }
        return "Pardon?";
    }
}
