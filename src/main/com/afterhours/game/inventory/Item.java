package com.afterhours.game.inventory;

import java.util.ArrayList;
import java.util.List;

public enum Item {
    POSTER(ItemConstants.POSTER_DESCRIPTION_TEXT, false, new String[] {"poster"}),
    NIGHTSTICK("It's a nightstick.", true, new String[] {"nightstick", "stick"}),
    BADGE(ItemConstants.BADGE_DESCRIPTION_TEXT, true, new String[] {"stick"}),
    LIGHTER(ItemConstants.LIGHTER_DESCRIPTION_TEXT, true, new String[] {"lighter"}),
    LOST_BOX(ItemConstants.LOST_BOX_DESCRIPTION_TEXT, false, new String[] {"lost box", "box", "lost and found"}, new Item[] {Item.POSTER}),
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
    private boolean isOpen;
    private List<String> synonyms;
    private List<Item> contents;

    Item(String description, boolean takeable, String[] synonyms, Item[] contents) {
        this.description = description;
        this.firstDescription = description;
        this.hasBeenSeen = true;
        this.takeable = takeable;
        this.synonyms = new ArrayList<>();
        for (String synonym: synonyms) {
            this.synonyms.add(synonym);
        }
        this.isOpen = false;
        this.contents = new ArrayList<>();
        for (Item content: contents) {
            this.contents.add(content);
        }
    }

    Item(String description, boolean takeable, String[] synonyms) {
        this.description = description;
        this.firstDescription = description;
        this.hasBeenSeen = true;
        this.takeable = takeable;
        this.synonyms = new ArrayList<>();
        for (String synonym: synonyms) {
            this.synonyms.add(synonym);
        }
        this.isOpen = false;
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
        this.isOpen = false;
    }

    public String getDescription() {
        String displayDescription = (hasBeenSeen) ? description : firstDescription;
        if (isOpenable(this)) {
            displayDescription += getOpenStatus();
        }
        return displayDescription;
    }

    private String getOpenStatus() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n\nIt is currently ");

        if (isOpen()) {
            stringBuilder.append("open.");
            if (getContents().size() > 0) {
                stringBuilder.append(" Inside you find ");
                stringBuilder.append(ItemUtils.generateListOfItems(getContents()));
                stringBuilder.append(" and... no, that's it.");
            } else if (getContents().size() == 0) {
                stringBuilder.append("Alas, it is empty.");
            } else {
                //IS THIS POSSIBLE? I think probably not, but I VERY MUCH HOPE SO
                stringBuilder.append("Somehow, it's even less than empty.");
            }
        } else {
            stringBuilder.append("closed.");
        }

        return stringBuilder.toString();
    }

    public List<String> getSynonyms() {
        return synonyms;
    }

    public boolean isTakeable() {
        return takeable;
    }

    public static boolean isOpenable(Item item) {
        return item.equals(Item.LOST_BOX) || item.equals(Item.DOOR);
    }

    public boolean isOpen() {
        return this.isOpen;
    }

    public void open() {
        this.isOpen = true;
    }

    public void close() {
        this.isOpen = false;
    }

    public List<Item> getContents() { return contents; }

    public String getItemName() {
        return this.name().replace('_', ' ').toLowerCase();
    }
}
