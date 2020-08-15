package com.afterhours.game.strategy;

import com.afterhours.game.direction.Direction;
import com.afterhours.game.direction.DirectionParser;
import com.afterhours.game.inventory.Inventory;
import com.afterhours.game.inventory.Item;
import com.afterhours.game.player.Player;

public class ExamineProcessor implements ProcessorStrategy {
    DirectionParser directionParser = new DirectionParser();

    public String processAction(Player player, String... input) {
        if (input.length == 1) {
            return player.getLocation().getDescription();
        }

        Direction directionToLook = directionParser.parseDirection(input[input.length-1]);
        if (directionToLook != Direction.NONE) {
            switch (directionToLook) {
                case NORTH:
                    return player.look(0, 1);
                case SOUTH:
                    return player.look(0, -1);
                case WEST:
                    return player.look(-1, 0);
                case EAST:
                    return player.look(1, 0);
                default:
                    return player.look(0, 0);
            }
        } else {
            String itemToSee = generateItemToSee(input);
            for (Item item : Item.values()) {
                if (itemToSee.toUpperCase().equals(item.name())) {
                    return (canSeeFromHere(player, item)) ? item.getDescription() : "You can't see that from here";
                }
            }
            return "Look at what?";
        }
    }

    private String generateItemToSee(String... input) {
        StringBuilder item = new StringBuilder();
        for (int i = 2; i<input.length; i++) {
            item.append(input[i]);
            item.append(' ');
        }

        return item.toString().trim();
    }

    private boolean canSeeFromHere(Player player, Item item) {
        Inventory inventory = player.getInventory();
        boolean playerHasItem = inventory.getInventory().contains(item);
        boolean playerIsInRoomWithItem = player.getLocation().getItemsList().contains(item);
        return playerHasItem || playerIsInRoomWithItem;
    }

}
