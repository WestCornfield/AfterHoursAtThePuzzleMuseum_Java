package com.afterhours.game.direction;

import com.afterhours.game.action.Action;

public class DirectionParser {
    public Direction parseDirection(String input) {
        try {
            return Direction.valueOf(input.toUpperCase());
        }
        catch (Exception e) {
            return Direction.NONE;
        }
    }
}
