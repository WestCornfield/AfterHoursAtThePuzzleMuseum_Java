package com.afterhours.game.inventory;

public enum Item {
    NIGHTSTICK("It's a nightstick."),
    BADGE(ItemConstants.BADGE_DESCRIPTION_TEXT),
    LIGHTER(ItemConstants.LIGHTER_DESCRIPTION_TEXT),
    LOST_BOX(ItemConstants.LOST_BOX_DESCRIPTION_TEXT),
    STICK_OF_GUM("It's a stick of gum."),
    MAZE("It's a Labyrinth"),
    MAZE_WALL("It's the wall of a Labyrinth"),
    DOME(ItemConstants.DOME_DESCRIPTION_TEXT),
    PLAQUE(ItemConstants.PLAQUE_DESCRIPTION_TEXT),
    DOOR(ItemConstants.DOOR_DESCRIPTION_TEXT),
    TABLE(ItemConstants.TABLE_DESCRIPTION_TEXT),
    KEYHOLE(ItemConstants.KEYHOLE_DESCRIPTION_TEXT, ItemConstants.KEYHOLE_FIRST_DESCRIPTION_TEXT),
    MAGAZINE(ItemConstants.MAGAZINE_DESCRIPTION_TEXT),
    NAIL_FILE(ItemConstants.NAIL_FILE_DESCRIPTION_TEXT),
    BRASS_KEY(ItemConstants.BRASS_KEY_DESCRIPTION_TEXT);

    private String description;
    private String firstDescription;
    private boolean hasBeenSeen;

    Item(String description) {
        this.description = description;
        this.firstDescription = description;
        this.hasBeenSeen = true;
    }

    Item(String description, String firstDescription) {
        this.description = description;
        this.firstDescription = firstDescription;
        this.hasBeenSeen = false;
    }

    public String getDescription() {
        return (hasBeenSeen) ? description : firstDescription;
    }
}
