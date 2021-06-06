package com.afterhours.game.strategy;

import com.afterhours.game.inventory.ItemUtils;
import com.afterhours.game.player.Player;

public class CloseProcessor implements ProcessorStrategy  {
    public String processAction(Player player, String... input) {
        if (input.length == 1) {
            return "Close what?";
        }
        String item = ItemUtils.buildItem(input);
        String result = player.close(item);
        return processCloseResult(result, item);
    }

    public String processCloseResult(String result, String object) {
        switch (result) {
            case "success,open": return "You have closed the " + object;
            case "success,closed": return "The " + object + " is already closed";
            case "failure, not found": return "Sorry, you want to close what?";
            case "failure, not openable": return "You can't close the " + object;
            default: return "You can't reach the " + object + " from here";
        }
    }
}
