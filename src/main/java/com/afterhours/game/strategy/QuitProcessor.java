package com.afterhours.game.strategy;

import com.afterhours.game.player.Player;

public class QuitProcessor implements ProcessorStrategy {

    public String processAction() {
        return "Goodbye!";
    }

    public String processAction(Player player, String... input) {
        return processAction();
    }
}
