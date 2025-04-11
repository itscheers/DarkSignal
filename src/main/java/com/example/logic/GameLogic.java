package com.example.logic;

import com.example.models.GameState;

public class GameLogic {

    public void processChoice(GameState state, String choice) {
        if (choice == null || state.isGameOver()) return;

        switch (state.getCurrentQuestion()) {

            case "You received a mysterious message. Read it?":
                if ("Read".equals(choice)) {
                    state.setCurrentQuestion("The message contains coordinates. Go there?");
                } else {
                    state.setGameOver(true);
                    state.setResultMessage("Defeat. You missed a chance to discover the truth.");
                }
                break;

            case "The message contains coordinates. Go there?":
                if ("Go".equals(choice)) {
                    state.setCurrentQuestion("You arrive at an old house. Enter?");
                } else {
                    state.setGameOver(true);
                    state.setResultMessage("Defeat. You stayed safe but learned nothing.");
                }
                break;

            case "You arrive at an old house. Enter?":
                if ("Enter".equals(choice)) {
                    state.setCurrentQuestion("Inside, you find an ancient map. Examine it?");
                } else {
                    state.setGameOver(true);
                    state.setResultMessage("Defeat. You missed the main clue.");
                }
                break;

            case "Inside, you find an ancient map. Examine it?":
                if ("Examine".equals(choice)) {
                    state.setCurrentQuestion("The map shows a hidden stash. Look for a key?");
                } else {
                    state.setGameOver(true);
                    state.setResultMessage("Defeat. You ignored a vital clue.");
                }
                break;

            case "The map shows a hidden stash. Look for a key?":
                if ("Search".equals(choice)) {
                    state.setCurrentQuestion("You find a locked door. Open it?");
                } else {
                    state.setGameOver(true);
                    state.setResultMessage("Defeat. No key, no treasure.");
                }
                break;

            case "You find a locked door. Open it?":
                if ("Open".equals(choice)) {
                    state.setCurrentQuestion("Beyond the door, you find a hidden chamber. Explore further?");
                } else {
                    state.setGameOver(true);
                    state.setResultMessage("Defeat. The door remained shut forever.");
                }
                break;

            case "Beyond the door, you find a hidden chamber. Explore further?":
                if ("Explore".equals(choice)) {
                    state.setCurrentQuestion("Inside the chamber, you discover a cryptic inscription. Decipher it?");
                } else {
                    state.setGameOver(true);
                    state.setResultMessage("Defeat. You missed your chance to unveil the mystery.");
                }
                break;

            case "Inside the chamber, you discover a cryptic inscription. Decipher it?":
                if ("Decipher".equals(choice)) {
                    state.setCurrentQuestion("Having deciphered the inscription, you learn the secret location of the treasure. Go to the location?");
                } else {
                    state.setGameOver(true);
                    state.setResultMessage("Defeat. Without deciphering the clue, the secret remained hidden.");
                }
                break;

            case "Having deciphered the inscription, you learn the secret location of the treasure. Go to the location?":
                if ("Go".equals(choice)) {
                    state.setGameOver(true);
                    state.setResultMessage("Victory! You reached the treasure's location and claimed the prize.");
                } else {
                    state.setGameOver(true);
                    state.setResultMessage("Defeat. Your hesitation cost you the treasure.");
                }
                break;

            default:
                state.setGameOver(true);
                state.setResultMessage("Defeat. The story ends here.");
        }
    }
}
