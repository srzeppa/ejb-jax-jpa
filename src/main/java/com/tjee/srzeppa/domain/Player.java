package com.tjee.srzeppa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({ 
	@NamedQuery(name = "get.all.players", query = "Select p from Player p")
})
public class Player {
	
	private int id;
	private String firstname = "unknown";
	private String lastname = "unknown";
	private int age;
/*	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_team", nullable = true)
	private Team team;*/
	
	public Player() {
		
	}
	
	public Player(int id, String firstname, String lastname, int age, Team team) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
		/*this.team = team;*/
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

/*	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}*/

}
