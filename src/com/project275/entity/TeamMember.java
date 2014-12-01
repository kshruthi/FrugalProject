package com.project275.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * TeamMember entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "team_member", catalog = "test1")
public class TeamMember implements java.io.Serializable {

	// Fields

	private Integer teamMemberid;
	private Team team;
	private User user;

	// Constructors

	/** default constructor */
	public TeamMember() {
	}

	/** full constructor */
	public TeamMember(Team team, User user) {
		this.team = team;
		this.user = user;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "team_memberid", unique = true, nullable = false)
	public Integer getTeamMemberid() {
		return this.teamMemberid;
	}

	public void setTeamMemberid(Integer teamMemberid) {
		this.teamMemberid = teamMemberid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "teamid")
	public Team getTeam() {
		return this.team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userid")
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}