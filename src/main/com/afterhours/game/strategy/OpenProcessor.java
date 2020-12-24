package com.afterhours.game.strategy;

import com.afterhours.game.inventory.ItemUtils;
import com.afterhours.game.player.Player;

public class OpenProcessor implements ProcessorStrategy {
    public String processAction(Player player, String... input) {
        if (input.length == 1) {
            return "Open what?";
        }
        String item = ItemUtils.buildItem(input);
        String result = player.open(item);
        return processOpenResult(result, item);
    }

    public String processOpenResult(String result, String object) {
        if (result.equals("success,closed")) {
            return "You have opened the " + object;
        } else if (result.equals("success,open")) {
            return "The "+object+" is already open";
        } else if (result.equals("failure, not found")) {
            return "Sorry, you want to take what?";
        } else if (result.equals("failure, not openable")) {
            return "You can't open the " + object;
        } else {
            return "You can't reach the " + object + " from here";
        }
    }
}
