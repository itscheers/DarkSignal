package com.example.controllers;

import com.example.logic.GameLogic;
import com.example.models.GameState;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class GameServlet extends HttpServlet {

    private final GameLogic gameLogic = new GameLogic();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        GameState state = (GameState) session.getAttribute("gameState");

        if (state == null) {
            response.sendRedirect(request.getContextPath() + "/start");
            return;
        }

        if (state.isGameOver()) {
            response.sendRedirect(request.getContextPath() + "/result");
            return;
        }

        request.setAttribute("question", state.getCurrentQuestion());
        request.setAttribute("playerName", state.getPlayerName());
        request.getRequestDispatcher("/game.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        GameState state = (GameState) session.getAttribute("gameState");

        if (state == null) {
            System.out.println("DEBUG: gameState == null — redirect to start");
            response.sendRedirect(request.getContextPath() + "/start");
            return;
        }

        String choice = request.getParameter("choice");
        System.out.println("DEBUG: Received choice from form: [" + choice + "]");

        gameLogic.processChoice(state, choice);

        // Debug: state после обработки
        System.out.println("DEBUG: After processing — question = [" + state.getCurrentQuestion() + "]");
        System.out.println("DEBUG: gameOver? " + state.isGameOver());

        session.setAttribute("gameState", state);

        if (state.isGameOver()) {
            response.sendRedirect(request.getContextPath() + "/result");
        } else {
            response.sendRedirect(request.getContextPath() + "/game");
        }
    }
}
