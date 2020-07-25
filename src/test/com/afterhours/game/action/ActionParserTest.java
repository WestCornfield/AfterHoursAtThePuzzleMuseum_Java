package com.afterhours.game.action;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ActionParserTest {
    ActionParser testObj = new ActionParser();

    @Test
    void parseActionGibberish() {
        Action action = testObj.parseAction("?asdnmaf");
        assertEquals(action.name(), "GIBBERISH");
    }

    @Test
    void parseActionMove() {
        Action action = testObj.parseAction("move north");
        assertEquals(action.name(), "MOVE");
    }

    @Test
    void parseActionTalk() {
        Action action = testObj.parseAction("talk to beth");
        assertEquals(action.name(), "TALK");
    }

    @Test
    void parseActionExamine() {
        Action action = testObj.parseAction("look north");
        assertEquals(action.name(), "LOOK");
    }

    @Test
    void parseActionInventory() {
        Action action = testObj.parseAction("i");
        assertEquals(action.name(), "INVENTORY");
    }
}
