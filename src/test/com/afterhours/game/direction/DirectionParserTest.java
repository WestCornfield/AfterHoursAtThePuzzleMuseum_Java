package com.afterhours.game.direction;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DirectionParserTest {
    DirectionParser testObj = new DirectionParser();

    @Test
    void parseDirectionNorth() {
        Direction direction = testObj.parseDirection("north");
        assertEquals(direction.name(), "NORTH");
    }

    @Test
    void parseDirectionSouth() {
        Direction direction = testObj.parseDirection("south");
        assertEquals(direction.name(), "SOUTH");
    }

    @Test
    void parseDirectionEast() {
        Direction direction = testObj.parseDirection("east");
        assertEquals(direction.name(), "EAST");
    }

    @Test
    void parseDirectionWest() {
        Direction direction = testObj.parseDirection("west");
        assertEquals(direction.name(), "WEST");
    }

    @Test
    void parseDirectionUp() {
        Direction direction = testObj.parseDirection("up");
        assertEquals(direction.name(), "UP");
    }

    @Test
    void parseDirectionDown() {
        Direction direction = testObj.parseDirection("down");
        assertEquals(direction.name(), "DOWN");
    }

    @Test
    void parseDirectionSingleLetter() {
        Direction direction = testObj.parseDirection("d");
        assertEquals(direction.name(), "DOWN");
    }
}
