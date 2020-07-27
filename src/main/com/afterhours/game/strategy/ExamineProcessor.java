package com.afterhours.game.strategy;

import com.afterhours.game.inventory.Item;
import com.afterhours.game.location.Location;
import com.afterhours.game.player.Player;

public class ExamineProcessor implements ProcessorStrategy {
    public String processAction(Player player, String... input) {
        if (input.length == 1) {
            return player.getLocation().getDescription();
        } else {
            String itemToSee = generateItemToSee(input);
            for (Item item : Item.values()) {

                if (itemToSee.toUpperCase().equals(item.name())) {
                    Location currentLocation = player.getLocation();
                    return (currentLocation.getItemsList().contains(item)) ? item.getDescription() : "You can't see that from here";
                }
            }
            return "Look at what?";
        }
    }

    private String generateItemToSee(String... input) {
        StringBuilder item = new StringBuilder();
        for (int i = 2; i<input.length; i++) {
            item.append(input[i]);
            if (i != input.length -1) {
                item.append(' ');
            }
        }

        return item.toString();
    }
}
