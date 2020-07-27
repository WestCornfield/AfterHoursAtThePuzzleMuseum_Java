package com.afterhours.game.direction;

public class DirectionParser {
    public Direction parseDirection(String input) {
        try {
            for (Direction direction : Direction.values()) {
                if (isDirection(input, direction)) {
                    return direction;
                }
            }
            return Direction.NONE;
        }
        catch (Exception e) {
            return Direction.NONE;
        }
    }

    private boolean isDirection(String input, Direction direction) {
        return input.toUpperCase().contains(direction.getName()) || input.toUpperCase().equals(direction.getSingleLetter());
    }
}
