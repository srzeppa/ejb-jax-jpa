package com.tjee.srzeppa.service;

import java.util.List;

import com.tjee.srzeppa.domain.Player;
import com.tjee.srzeppa.domain.Team;

public interface PlayerDao {
	
	void addPlayer(Player player);
	List<Player> getAllPlayers();
	void deletePlayer(Player player);
	Player getPlayerById(int id);
	void updatePlayer(Player player);
//	public void addTeamToPlayer(int playerId, int teamId);
//	public Team getOwnedTeam(Player player);

}
