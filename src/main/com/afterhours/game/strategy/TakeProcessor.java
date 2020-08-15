package com.afterhours.game.strategy;

import com.afterhours.game.player.Player;

public class TakeProcessor implements ProcessorStrategy {
    public String processAction(Player player, String... input) {
        if (input.length == 1) {
            return "Take what?";
        }
        String object = buildObject(input);
        boolean taken = player.pickup(object);
        return (taken) ? "You have taken the " + object : "You can't take the " + object;
    }

    public String buildObject(String[] input) {
        StringBuilder builder = new StringBuilder();
        for (int index=1; index < input.length; index++) {
            builder.append(input[index]);
            builder.append(" ");
        }
        return builder.toString().trim();
    }
}
