package com.afterhours.game.strategy;

import com.afterhours.game.action.Action;

public class ProcessorStrategyFactory {
    public ProcessorStrategy determineStrategy(Action action) {
        if (action.equals(Action.INVENTORY)) {
            return new InventoryProcessor();
        }
        if (action.equals(Action.LOOK)) {
            return new ExamineProcessor();
        }
        if (action.equals(Action.MOVE)) {
            return new MovementProcessor();
        }
        if (action.equals(Action.TALK)) {
            return null;
        }
        if (action.equals(Action.TAKE)) {
            return new TakeProcessor();
        }
        if (action.equals(Action.OPEN)) {
            return new OpenProcessor();
        }
        if (action.equals(Action.CLOSE)) {
            return new CloseProcessor();
        }
        return new GibberishProcessor();
    }
}
