package com.afterhours.game.direction;

public enum Direction {
    NORTH("NORTH", "N"),
    SOUTH("SOUTH", "S"),
    EAST("EAST", "E"),
    WEST("WEST", "W"),
    UP("UP", "U"),
    DOWN("DOWN", "D"),
    NONE("NONE", "n/a");

    private String name;
    private String singleLetter;

    Direction(String name, String singleLetter) {
        this.name = name;
        this.singleLetter = singleLetter;
    }

    public String getName() {
        return this.name;
    }

    public String getSingleLetter() {
        return this.singleLetter;
    }

}
