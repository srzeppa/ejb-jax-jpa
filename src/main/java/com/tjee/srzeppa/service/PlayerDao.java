package com.tjee.srzeppa.service;

import java.util.List;

import com.tjee.srzeppa.domain.Player;

public interface PlayerDao {
	
	void addClient(Player player);
	List<Player> getAllPlayers();
	void deletePlayer(Player player);
	Player getPlayerById(int id);
	void updatePlayer(Player player);
	public void addTeamToPlayer(int playerId, int teamId);

}
