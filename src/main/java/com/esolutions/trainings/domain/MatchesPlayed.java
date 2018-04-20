package com.esolutions.trainings.domain;

import com.esolutions.trainings.db.TeamConverter;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "matches_played")
@Entity
public class MatchesPlayed {
	@Id
	private Integer id;

	@Column
	private Integer year;

	@ManyToOne(optional = false)
	@JoinColumn(name = "player_id")
	private Player player;

	@Convert(converter = TeamConverter.class)
	@Column()
	private Team team;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}


}
