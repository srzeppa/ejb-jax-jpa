package com.tjee.srzeppa.rest;

import java.util.List;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServlet;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.tjee.srzeppa.domain.Player;
import com.tjee.srzeppa.service.PlayerDao;
import com.tjee.srzeppa.service.PlayerDaoImpl;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.PUT;

@Stateless
@Path("/player")
public class PlayerResource {
	@EJB
	private PlayerDaoImpl playerDao;

	@GET
	@Path("/getAll")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Player> getPlayers() {
		return playerDao.getAllPlayers();
	}

	@POST
	@Path("/add")
	@Produces(MediaType.APPLICATION_JSON)
	public Player add(@FormParam("firstname") String firstname, @FormParam("lastname") String lastname,
			@FormParam("age") int age) {
		Player player = new Player();

		player.setFirstname(firstname);
		player.setLastname(lastname);
		player.setAge(age);

		playerDao.addPlayer(player);

		return player;
	}

	@PUT
	@Path("/edit/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Player edit(@PathParam("id") int id, @FormParam("firstname") String firstname, @FormParam("lastname") String lastname,
			@FormParam("age") int age) {
		Player player = new Player();

		player = playerDao.getPlayerById(id);

		return player;
	}

	@DELETE
	@Path("/delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void usun(@PathParam("id") int id) {
		Player player = new Player();

		playerDao.deletePlayer(player);
	}

	@GET
	@Path("/show/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Player show(@PathParam("id") int id) {
		return playerDao.getPlayerById(id);
	}
}
