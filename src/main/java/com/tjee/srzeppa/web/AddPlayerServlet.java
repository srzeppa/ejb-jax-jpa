package com.tjee.srzeppa.web;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.tjee.srzeppa.service.PlayerDao;

@WebServlet(urlPatterns = "/playeradd")
public class AddPlayerServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	@EJB
    private PlayerDao playerDao;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/playerRest/addRest.jsp").forward(request, response);
    }

}
