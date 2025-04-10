package com.example.controllers;

import com.example.models.GameState;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class StartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/welcome.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String playerName = request.getParameter("playerName");

        HttpSession session = request.getSession();
        Integer gameCounter = (Integer) session.getAttribute("gameCounter");
        if (gameCounter == null) {
            gameCounter = 1;
        } else {
            gameCounter++;
        }

        GameState state = new GameState();
        state.setPlayerName(playerName);
        state.setGameCounter(gameCounter);

        session.setAttribute("gameCounter", gameCounter);
        session.setAttribute("gameState", state);
        response.sendRedirect(request.getContextPath() + "/game");
    }
}
