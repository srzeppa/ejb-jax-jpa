package com.tjee.srzeppa.jaxrs;

import java.net.URISyntaxException;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
			
			/*java.net.URI location;
			try {
				location = new java.net.URI("../player/showPlayers.jsp");
				return Response.temporaryRedirect(location).build();
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
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
	
	@PUT
    @Path("/edit/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Player edit(
            @PathParam("id") int id,
            @FormParam("firstname") String firstname,
            @FormParam("lastname") String lastname,
            @FormParam("age") Integer age)
    {
	 	Player player = new Player();
	
	 	player = playerDao.getPlayerById(id);
	 	player.setAge(age);
	 	player.setFirstname(firstname);
	 	player.setLastname(lastname);
	 	
		playerDao.updatePlayer(player);
		
	    return player;
    }
	
	
	
}
