package com.afterhours.game.strategy;

import com.afterhours.game.player.Player;

public interface ProcessorStrategy {
    String processAction(Player player, String... input);
}
