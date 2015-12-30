package com.tjee.srzeppa.domain;

import java.util.List;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({ 
	@NamedQuery(name = "get.all.teams", query = "Select t from Team t")
})
public class Team {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name = "unknown";
	@OneToMany
	private List<Player> players = new ArrayList<Player>();
	
	public Team() {
		
	}
	
	public Team(int id, String name, List<Player> players) {
		this.id = id;
		this.name = name;
		this.players = players;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	
	

}
