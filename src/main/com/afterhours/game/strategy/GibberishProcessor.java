package com.afterhours.game.strategy;

import com.afterhours.game.player.Player;

public class GibberishProcessor implements ProcessorStrategy {
    public String processAction(Player player, String... input) {
        return "Pardon?";
    }
}
