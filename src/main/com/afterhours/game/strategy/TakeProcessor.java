package com.afterhours.game.strategy;

import com.afterhours.game.player.Player;

public class TakeProcessor implements ProcessorStrategy {
    public String processAction(Player player, String... input) {
        if (input.length == 1) {
            return "Take what?";
        }
        String object = buildObject(input);
        String result = player.pickup(object);
        return processTakeResult(result, object);
    }

    public String buildObject(String[] input) {
        StringBuilder builder = new StringBuilder();
        for (int index=1; index < input.length; index++) {
            builder.append(input[index]);
            builder.append(" ");
        }
        return builder.toString().trim();
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
