package com.afterhours.game.action;

public class ActionParser {
    public Action parseAction(String input) {
        try {
            String[] inputWords = splitInput(input);
            Action actionToReturn = Action.GIBBERISH;
            for (Action action: Action.values()) {
                for (String synonym: action.getSynonyms()) {
                    if (actionMatch(inputWords, synonym)) {
                        actionToReturn = action;
                        break;
                    }
                }
            }
            return actionToReturn;
        }
        catch (Exception e) {
            return Action.GIBBERISH;
        }
    }

    private String[] splitInput(String input) {
        return input.split(" ");
    }

    private boolean actionMatch(String[] inputWords, String synonym) {
        return inputWords[0].toLowerCase().equals(synonym);
    }
}
