package com.afterhours.game.inventory;

import java.util.ArrayList;
import java.util.List;

public enum Item {
    NIGHTSTICK("It's a nightstick.", true, new String[] {"nightstick", "stick"}),
    BADGE(ItemConstants.BADGE_DESCRIPTION_TEXT, true, new String[] {"stick"}),
    LIGHTER(ItemConstants.LIGHTER_DESCRIPTION_TEXT, true, new String[] {"lighter"}),
    LOST_BOX(ItemConstants.LOST_BOX_DESCRIPTION_TEXT, false, new String[] {"lost box", "box", "lost and found"}),
    STICK_OF_GUM("It's a stick of gum.", true, new String[] {"gum", "stick of gum"}),
    MAZE("It's a Labyrinth", false, new String[] {"maze", "labyrinth"}),
    MAZE_WALL("It's the wall of a Labyrinth", false, new String[] {"wall", "maze wall", "labyrinth wall"}),
    DOME(ItemConstants.DOME_DESCRIPTION_TEXT, false, new String[] {"dome"}),
    PLAQUE(ItemConstants.PLAQUE_DESCRIPTION_TEXT, false, new String[] {"plaque"}),
    DOOR(ItemConstants.DOOR_DESCRIPTION_TEXT, false, new String[] {"door"}),
    TABLE(ItemConstants.TABLE_DESCRIPTION_TEXT, false, new String[] {"table"}),
    KEYHOLE(ItemConstants.KEYHOLE_DESCRIPTION_TEXT, ItemConstants.KEYHOLE_FIRST_DESCRIPTION_TEXT, new String[] {"keyhole", "hole"}),
    MAGAZINE(ItemConstants.MAGAZINE_DESCRIPTION_TEXT, true, new String[] {"magazine"}),
    NAIL_FILE(ItemConstants.NAIL_FILE_DESCRIPTION_TEXT, true, new String[] {"file", "nail file"}),
    BRASS_KEY(ItemConstants.BRASS_KEY_DESCRIPTION_TEXT, false, new String[] {"brass key"}),
    NOT_FOUND("N/A", false, new String[] {});

    private String description;
    private String firstDescription;
    private boolean hasBeenSeen;
    private boolean takeable;
    private List<String> synonyms;

    Item(String description, boolean takeable, String[] synonyms) {
        this.description = description;
        this.firstDescription = description;
        this.hasBeenSeen = true;
        this.takeable = takeable;
        this.synonyms = new ArrayList<>();
        for (String synonym: synonyms) {
            this.synonyms.add(synonym);
        }
    }

    Item(String description, String firstDescription, String[] synonyms) {
        this.description = description;
        this.firstDescription = firstDescription;
        this.hasBeenSeen = false;
        this.takeable = false;
        this.synonyms = new ArrayList<>();
        for (String synonym: synonyms) {
            this.synonyms.add(synonym);
        }
    }

    public String getDescription() {
        return (hasBeenSeen) ? description : firstDescription;
    }

    public List<String> getSynonyms() {
        return synonyms;
    }

    public boolean isTakeable() {
        return takeable;
    }
}
