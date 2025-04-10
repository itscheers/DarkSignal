package com.example.controllers;

import com.example.models.GameState;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class ResultServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        GameState state = (GameState) session.getAttribute("gameState");

        if (state == null || !state.isGameOver()) {
            response.sendRedirect(request.getContextPath() + "/start");
            return;
        }

        request.setAttribute("resultMessage", state.getResultMessage());
        request.setAttribute("playerName", state.getPlayerName());
        request.setAttribute("gameCounter", state.getGameCounter());
        request.getRequestDispatcher("/result.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.removeAttribute("gameState");
        response.sendRedirect(request.getContextPath() + "/start");
    }
}
