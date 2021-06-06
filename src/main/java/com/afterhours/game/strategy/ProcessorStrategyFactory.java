package com.afterhours.game.strategy;

import com.afterhours.game.action.Action;

public class ProcessorStrategyFactory {
    public ProcessorStrategy determineStrategy(Action action) {
        switch (action) {
            case INVENTORY: return new InventoryProcessor();
            case LOOK: return new ExamineProcessor();
            case MOVE: return new MovementProcessor();
            case TALK: return null;
            case TAKE: return new TakeProcessor();
            case OPEN: return new OpenProcessor();
            case CLOSE: return new CloseProcessor();
            case DROP: return new DropProcessor();
            default: return new GibberishProcessor();
        }
    }
}
