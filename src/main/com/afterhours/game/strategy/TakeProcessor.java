package com.afterhours.game.strategy;

import com.afterhours.game.inventory.Item;
import com.afterhours.game.player.Player;

public class TakeProcessor implements ProcessorStrategy {
    public String processAction(Player player, String... input) {
        if (input.length == 1) {
            return "Take what?";
        }
        String object = input[input.length-1].toUpperCase();
        player.pickup(Item.valueOf(object));
        return "You have taken the " + input[input.length-1];
    }
}
