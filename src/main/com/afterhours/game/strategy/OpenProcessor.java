package com.afterhours.game.strategy;

import com.afterhours.game.player.Player;

public class OpenProcessor implements ProcessorStrategy {
    public String processAction(Player player, String... input) {
        if (input.length == 1) {
            return "Open what?";
        }
        String object = buildObject(input);
        String result = player.open(object);
        return processOpenResult(result, object);
    }

    public String buildObject(String[] input) {
        StringBuilder builder = new StringBuilder();
        for (int index=1; index < input.length; index++) {
            builder.append(input[index]);
            builder.append(" ");
        }
        return builder.toString().trim();
    }

    public String processOpenResult(String result, String object) {
        if (result.equals("success")) {
            return "You have opened the " + object;
        } else if (result.equals("failure, not found")) {
            return "Sorry, you want to take what?";
        } else if (result.equals("failure, not openable")) {
            return "You can't open the " + object;
        } else {
            return "You can't reach the " + object + " from here";
        }
    }
}
