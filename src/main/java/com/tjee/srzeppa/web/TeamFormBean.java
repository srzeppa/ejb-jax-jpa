package com.tjee.srzeppa.web;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.tjee.srzeppa.domain.Player;
import com.tjee.srzeppa.domain.Team;
import com.tjee.srzeppa.service.PlayerDao;
import com.tjee.srzeppa.service.TeamDao;

@SessionScoped
@Named("teamBean")
public class TeamFormBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Team team = new Team();
	private Player playerToShow = new Player();
	private ListDataModel<Team> teams = new ListDataModel<Team>();
	private ListDataModel<Player> players = new ListDataModel<Player>();

	@Inject
	private PlayerDao playerDao;
	@Inject
	private TeamDao teamDao;

	private int playerId;
	private int teamId;

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public ListDataModel<Team> getAllTeams() {
		teams.setWrappedData(teamDao.getAllTeams());
		return teams;
	}

	public void deleteTeam() {
		team = teams.getRowData();
		teamDao.deleteTeam(team);
	}

	public void editTeam() {
		team = teams.getRowData();
		teamDao.updateTeam(team);
	}

	public List<Player> getAllPlayers() {
		return playerDao.getAllPlayers();
	}

	public List<String> getAllPlayersNames() {
		List <String> tmp = new ArrayList();
		players.setWrappedData(teamDao.getTeamPlayers(team));
		for(Player player : players){
			tmp.add(player.getFirstname());
		}
		return tmp;
	}

	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public String playerToTeam() {
		teamDao.addPlayerToTeam(teamId, playerId);
		return null;
	}

	public String addTeam() {
		teamDao.addTeam(team);
		return "showTeams";
	}

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public String showProperties() {
		team = teams.getRowData();
		return "details";
	}
	
	public String update(){
		teamDao.updateTeam(team);
		return "showTeams";
	}
	
	public String showEdit(){
		team = teams.getRowData();
		teamDao.updateTeam(team);
		return "showEdit";
	}

}
