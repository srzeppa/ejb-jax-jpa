package com.tjee.srzeppa.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.tjee.srzeppa.domain.Player;
import com.tjee.srzeppa.domain.Team;

@Stateless
public class TeamDaoImpl implements TeamDao{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void addTeam(Team team) {
		entityManager.persist(team);
		
	}

	@Override
	public List<Team> getAllTeams() {
		return entityManager.createNamedQuery("get.all.teams").getResultList();
	}

	@Override
	public void deleteTeam(Team team) {
		team = entityManager.find(Team.class, team.getId());
		entityManager.remove(team);
	}

	@Override
	public Team getTeamById(int id) {
		return (Team) entityManager.find(Team.class, id);
	}

	@Override
	public void updateTeam(Team team) {
		// TODO Auto-generated method stub
		
	}

}
