package com.afterhours.game.action;

import java.util.ArrayList;
import java.util.List;

public enum Action {
    MOVE(new String[]{"move", "go", "north", "south", "west", "east", "up", "down", "n", "s", "w", "e", "u", "d"}),
    TAKE(new String[]{"take", "retrieve", "grab", "obtain"}),
    TALK(new String[]{"talk", "say"}),
    LOOK(new String[]{"look", "examine"}),
    OPEN(new String[]{"open"}),
    INVENTORY(new String[]{"inventory", "i"}),
    GIBBERISH;

    private List<String> synonyms;

    Action() {
        this.synonyms = new ArrayList<>();
    }

    Action(String[] synonyms) {
        this.synonyms = new ArrayList<>();
        for (String synonym: synonyms) {
            this.synonyms.add(synonym);
        }

    }

    public List<String> getSynonyms() {
        return synonyms;
    }

}
