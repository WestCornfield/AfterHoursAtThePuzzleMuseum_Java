package com.afterhours.game.action;

public class ActionParser {
    public Action parseAction(String input) {
        try {
            for (Action action : Action.values()) {
                if (input.toUpperCase().contains(action.name())) {
                    return action;
                }
            }
        }
        catch (Exception e) {
            return Action.GIBBERISH;
        }

        return Action.GIBBERISH;
    }
}
