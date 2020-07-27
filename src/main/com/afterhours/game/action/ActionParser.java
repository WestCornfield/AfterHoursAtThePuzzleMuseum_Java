package com.afterhours.game.action;

public class ActionParser {
    public Action parseAction(String input) {
        try {
            for (Action action: Action.values()) {
                for (String synonym: action.getSynonyms()) {
                    if (input.toLowerCase().contains(synonym)) {
                        return action;
                    }
                }
            }
        }
        catch (Exception e) {
            return Action.GIBBERISH;
        }

        return Action.GIBBERISH;
    }
}
