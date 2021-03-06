package com.tjee.srzeppa.service;

import java.util.List;

import com.tjee.srzeppa.domain.Team;
import com.tjee.srzeppa.domain.Player;

public interface TeamDao {
	
	void addTeam(Team team);
	List<Team> getAllTeams();
	void deleteTeam(Team team);
	Team getTeamById(int id);
	void updateTeam(Team team);
	void addPlayerToTeamList(int teamId, List<Player> playerList);
	List<Player> getPlayers(Team team);
	void addPlayerToTeam(int teamId, int playerId);
	List<Player> getTeamPlayers(Team team);

}
