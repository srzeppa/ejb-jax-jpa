package com.tjee.srzeppa.web;

import java.io.Serializable;
import java.util.List;

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
	
	@Inject
	private PlayerDao playerDao;
	@Inject
	private TeamDao teamDao;
	
	private int playerId;

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
	
	public String update(){
//		player = players.getRowData();
		playerDao.updatePlayer(player);
		return "showPlayers";
	}
	
	public String showEdit(){
		player = players.getRowData();
		playerDao.updatePlayer(player);
		return "showEdit";
	}
	
	public String showProperties() {
		player = players.getRowData();
		return "details";
	}
	
	public List<Player> getAvaiablePlayers() {
		return playerDao.getAvaiablePlayers();
	}

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

}
