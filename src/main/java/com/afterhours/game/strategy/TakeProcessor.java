package com.afterhours.game.strategy;

import com.afterhours.game.inventory.ItemUtils;
import com.afterhours.game.player.Player;

public class TakeProcessor implements ProcessorStrategy {
    public String processAction(Player player, String... input) {
        if (input.length == 1) {
            return "Take what?";
        }
        String item = ItemUtils.buildItem(input);
        String result = player.pickup(item);
        return processTakeResult(result, item);
    }

    public String processTakeResult(String result, String object) {
        if (result.equals("success")) {
            return "You have taken the " + object;
        } else if (result.equals("failure, not found")) {
            return "Sorry, you want to take what?";
        } else if (result.equals("failure, not takeable")) {
            return "You can't take the " + object;
        } else {
            return "You can't reach the " + object + " from here";
        }
    }
}
