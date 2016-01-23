package com.tjee.srzeppa.jaxrs;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.tjee.srzeppa.domain.*;
import com.tjee.srzeppa.service.*;

@Stateless
@Path("/playerr")
public class PlayerRest {
	
	@EJB
	private PlayerDao playerDao;

	
	@GET
	@Path("/getAll")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Player> getAll(){
		return playerDao.getAllPlayers();
	}
	
	
	@POST
	@Path("/add")
	@Produces(MediaType.APPLICATION_JSON)
	public Player add(
		@FormParam("firstname") String firstname,
		@FormParam("lastname") String lastname,
		@FormParam("age") int age
	){
			Player player = new Player();
			
			player.setFirstname(firstname);
			player.setLastname(lastname);
			player.setAge(age);
			
			playerDao.addPlayer(player);
			
			return player;
	}
	
	
	@DELETE
	@Path("/delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void delete(
			@PathParam("id") int id
	){
		playerDao.deletePlayer(playerDao.getPlayerById(id));
	}
	
	@GET
	@Path("/show/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Player show(
			@PathParam("id") int id
	){
		return playerDao.getPlayerById(id);
	}
	
	
	
}
