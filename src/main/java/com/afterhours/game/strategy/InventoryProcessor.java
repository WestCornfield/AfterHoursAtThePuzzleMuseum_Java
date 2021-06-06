package com.afterhours.game.strategy;

import com.afterhours.game.player.Player;

public class InventoryProcessor implements ProcessorStrategy {
    public String processAction(Player player, String... input) {
        return player.printInventory();
    }
}
