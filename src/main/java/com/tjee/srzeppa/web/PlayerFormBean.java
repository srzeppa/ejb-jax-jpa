package com.tjee.srzeppa.web;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.tjee.srzeppa.domain.Player;
import com.tjee.srzeppa.domain.Team;
import com.tjee.srzeppa.service.PlayerDao;
import com.tjee.srzeppa.service.PlayerDaoImpl;
import com.tjee.srzeppa.service.TeamDao;

@SessionScoped
@Named("playerBean")
public class PlayerFormBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Player player = new Player();
	private ListDataModel<Player> players = new ListDataModel<Player>();
	private Team ownedTeam;
	
	@Inject
	private PlayerDao playerDao;
	@Inject
	private TeamDao teamDao;

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public ListDataModel<Player> getAllPlayers() {
		players.setWrappedData(playerDao.getAllPlayers());
		return players;
	}
	
	public String addPlayer() {
		playerDao.addPlayer(player);
		return "showPlayers";
	}
	
	public void deletePlayer(){
		player = players.getRowData();
		playerDao.deletePlayer(player);
	}
	
	public void editPlayer(){
		player = players.getRowData();
		playerDao.updatePlayer(player);
	}
	
	public String showProperties() {
		player = players.getRowData();
		return "details";
	}

}
