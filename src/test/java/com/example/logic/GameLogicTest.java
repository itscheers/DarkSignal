package com.example.logic;

import com.example.models.GameState;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameLogicTest {

    private GameLogic logic;
    private GameState state;

    @Before
    public void setUp() {
        logic = new GameLogic();
        state = new GameState();
    }

    @Test
    public void testVictoryPath() {
        state.setCurrentQuestion("You received a mysterious message. Read it?");
        logic.processChoice(state, "Read");
        logic.processChoice(state, "Go");
        logic.processChoice(state, "Enter");
        logic.processChoice(state, "Examine");
        logic.processChoice(state, "Search");
        logic.processChoice(state, "Open");
        logic.processChoice(state, "Explore");
        logic.processChoice(state, "Decipher");
        logic.processChoice(state, "Go");

        assertTrue(state.isGameOver());
        assertEquals("Victory! You reached the treasure's location and claimed the prize.", state.getResultMessage());
    }

    @Test
    public void testDefeatEarly() {
        state.setCurrentQuestion("You received a mysterious message. Read it?");
        logic.processChoice(state, "Ignore");

        assertTrue(state.isGameOver());
        assertEquals("Defeat. You missed a chance to discover the truth.", state.getResultMessage());
    }

    @Test
    public void testNullChoice() {
        state.setCurrentQuestion("You received a mysterious message. Read it?");
        logic.processChoice(state, null);

        assertFalse(state.isGameOver());
        assertEquals("You received a mysterious message. Read it?", state.getCurrentQuestion());
    }

    @Test
    public void testUnknownQuestion() {
        state.setCurrentQuestion("Some unknown question?");
        logic.processChoice(state, "Anything");

        assertTrue(state.isGameOver());
        assertEquals("Defeat. The story ends here.", state.getResultMessage());
        //everything is good
    }
}
