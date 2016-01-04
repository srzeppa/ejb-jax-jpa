package com.tjee.srzeppa.web;

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
	private ListDataModel<Team> teams = new ListDataModel<Team>();

	@Inject
	private PlayerDao playerDao;
	@Inject
	private TeamDao teamDao;

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

}
