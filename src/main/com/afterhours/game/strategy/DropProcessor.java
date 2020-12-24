package com.afterhours.game.strategy;

import com.afterhours.game.inventory.ItemUtils;
import com.afterhours.game.player.Player;

public class DropProcessor implements ProcessorStrategy {
    public String processAction(Player player, String... input) {
        if (input.length == 1) {
            return "Drop what?";
        }
        String item = ItemUtils.buildItem(input);
        String result = player.drop(item);
        return processDropResult(result, item);
    }

    public String processDropResult(String result, String object) {
        switch (result) {
            case "success,dropped": return "You have dropped the " + object;
            case "failure, not possessed": return "You can't drop the " + object + " when you don't have the " + object;
            default: return "Sorry, drop what?";
        }
    }
}
