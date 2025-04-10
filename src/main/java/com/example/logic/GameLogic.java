package com.example.logic;

import com.example.models.GameState;

public class GameLogic {

    public void processChoice(GameState state, String choice) {
        System.out.println("DEBUG: Current question = " + state.getCurrentQuestion());
        System.out.println("DEBUG: Player choice = " + choice);

        if (choice == null || state.isGameOver()) return;

        switch (state.getCurrentQuestion()) {
            case "You received a mysterious message. Read it?":
                if ("Read".equals(choice)) {
                    state.setCurrentQuestion("The message contains coordinates. Go there?");
                } else if ("Ignore".equals(choice)) {
                    state.setGameOver(true);
                    state.setResultMessage("Defeat. You missed a chance to discover the truth.");
                }
                break;

            case "The message contains coordinates. Go there?":
                if ("Go".equals(choice)) {
                    state.setCurrentQuestion("You arrive at an old house. Enter?");
                } else if ("Stay".equals(choice)) {
                    state.setGameOver(true);
                    state.setResultMessage("Defeat. You stayed safe but learned nothing.");
                }
                break;

            case "You arrive at an old house. Enter?":
                if ("Enter".equals(choice)) {
                    state.setCurrentQuestion("Inside, you find an ancient map. Examine it?");
                } else if ("Skip".equals(choice)) {
                    state.setGameOver(true);
                    state.setResultMessage("Defeat. You missed the main clue.");
                }
                break;

            case "Inside, you find an ancient map. Examine it?":
                if ("Examine".equals(choice)) {
                    state.setCurrentQuestion("The map shows a hidden stash. Look for a key?");
                } else if ("Ignore".equals(choice)) {
                    state.setGameOver(true);
                    state.setResultMessage("Defeat. You ignored a vital clue.");
                }
                break;

            case "The map shows a hidden stash. Look for a key?":
                if ("Search".equals(choice)) {
                    state.setCurrentQuestion("You find a locked door. Open it?");
                } else if ("Leave".equals(choice)) {
                    state.setGameOver(true);
                    state.setResultMessage("Defeat. No key, no treasure.");
                }
                break;

            case "You find a locked door. Open it?":
                if ("Open".equals(choice)) {
                    state.setGameOver(true);
                    state.setResultMessage("Victory! You found the secret and unlocked the treasure.");
                } else if ("Do not open".equals(choice)) {
                    state.setGameOver(true);
                    state.setResultMessage("Defeat. The door remained shut forever.");
                }
                break;

            default:
                state.setGameOver(true);
                state.setResultMessage("Defeat. The story ends here.");
        }

        System.out.println("DEBUG: New question = " + state.getCurrentQuestion());
    }
}
