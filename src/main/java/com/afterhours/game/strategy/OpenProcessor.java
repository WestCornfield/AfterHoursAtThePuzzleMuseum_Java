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
        switch (result) {
            case "success,closed": return "You have opened the " + object;
            case "success,open": return "The " + object + " is already open";
            case "failure, not found": return "Sorry, you want to open what?";
            case "failure, not openable": return "You can't open the " + object;
            default: return "You can't reach the " + object + " from here";
        }
    }
}
