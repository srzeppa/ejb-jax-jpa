package com.tjee.srzeppa.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.tjee.srzeppa.domain.Player;
import com.tjee.srzeppa.domain.Team;

@Stateless
public class PlayerDaoImpl implements PlayerDao{
	
	@PersistenceContext
	private EntityManager entityManager;

	public void addPlayer(Player player) {
		player.setId(0);
		entityManager.persist(player);
		
	}

	@SuppressWarnings("unchecked")
	public List<Player> getAllPlayers() {
		return entityManager.createNamedQuery("get.all.players").getResultList();
	}

	public void deletePlayer(Player player) {
		player = entityManager.find(Player.class, player.getId());
		entityManager.remove(player);
		
	}

	public Player getPlayerById(int id) {
		return (Player) entityManager.find(Player.class, id);
		
	}

	public void updatePlayer(Player player) {
//		player = entityManager.find(Player.class, player.getId());
		entityManager.merge(player);
	}
	
	public void updatePlayerWith(Player player, Team team, int age, String firstname, String lastname) {
		player = entityManager.find(Player.class, player.getId());
		
		player.setAge(age);
		player.setFirstname(firstname);
		player.setLastname(lastname);
		
		entityManager.merge(player);
	}

}
