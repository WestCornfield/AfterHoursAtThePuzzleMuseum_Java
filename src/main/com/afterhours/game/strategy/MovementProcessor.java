package com.afterhours.game.strategy;

import com.afterhours.game.direction.Direction;
import com.afterhours.game.direction.DirectionParser;
import com.afterhours.game.player.Player;

public class MovementProcessor implements ProcessorStrategy {
    public String processAction(Player player, String... input) {
        DirectionParser directionParser = new DirectionParser();
        Direction dir = directionParser.parseDirection(input[input.length-1]);
        switch (dir) {
            case NORTH:
                return player.move(0,1);
            case WEST:
                return player.move(-1,0);
            case SOUTH:
                return player.move(0,-1);
            case EAST:
                return player.move(1,0);
            default:
                return "Move where?";
        }
    }
}
