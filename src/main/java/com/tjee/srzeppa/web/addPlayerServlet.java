package com.tjee.srzeppa.web;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tjee.srzeppa.service.PlayerDao;


@WebServlet(urlPatterns = "/addPlayer")
public class addPlayerServlet extends HttpServlet{
    @EJB
    private PlayerDao playerDao;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("player/add.jsp").forward(request, response);
    }
}
