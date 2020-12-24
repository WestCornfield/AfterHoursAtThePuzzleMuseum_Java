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
        if (result.equals("success,open")) {
            return "You have closed the " + object;
        } else if (result.equals("success,closed")) {
            return "The "+object+" is already closed";
        } else if (result.equals("failure, not found")) {
            return "Sorry, you want to close what?";
        } else if (result.equals("failure, not openable")) {
            return "You can't close the " + object;
        } else {
            return "You can't reach the " + object + " from here";
        }
    }
}
