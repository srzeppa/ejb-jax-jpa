package com.tjee.srzeppa.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.tjee.srzeppa.domain.Player;

@Stateless
public class PlayerDaoImpl implements PlayerDao{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void addClient(Player player) {
		entityManager.persist(player);
		
	}

	@Override
	public List<Player> getAllPlayers() {
		return entityManager.createNamedQuery("get.all.players").getResultList();
	}

	@Override
	public void deletePlayer(Player player) {
		player = entityManager.find(Player.class, player.getId());
		entityManager.remove(player);
		
	}

	@Override
	public Player getPlayerById(int id) {
		return (Player) entityManager.find(Player.class, id);
		
	}

	@Override
	public void updatePlayer(Player player) {
		// TODO Auto-generated method stub
		
	}

}
