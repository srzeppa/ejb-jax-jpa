package com.tjee.srzeppa.web;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tjee.srzeppa.service.PlayerDao;

@WebServlet(urlPatterns = "/updatePlayer/*")
public class UpdatePlayerServlet extends HttpServlet{

	@EJB
	private PlayerDao playerDao;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String link = request.getPathInfo();
		request.setAttribute("editedPlayer",
				playerDao.getPlayerById(Integer.parseInt(link.substring(link.lastIndexOf("/") + 1, link.length()))));
		request.getRequestDispatcher("/player/edit.jsp").forward(request, response);
	}

}
