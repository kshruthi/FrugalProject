package com.project275.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Team entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "team", catalog = "test1")
public class Team implements java.io.Serializable {

	// Fields

	private Integer teamid;
	private String teamName;
	private String teamDesc;
	private Set<TeamMember> teamMembers = new HashSet<TeamMember>(0);
	private Set<Project> projects = new HashSet<Project>(0);

	// Constructors

	/** default constructor */
	public Team() {
	}

	/** full constructor */
	public Team(String teamName, String teamDesc, Set<TeamMember> teamMembers,
			Set<Project> projects) {
		this.teamName = teamName;
		this.teamDesc = teamDesc;
		this.teamMembers = teamMembers;
		this.projects = projects;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "teamid", unique = true, nullable = false)
	public Integer getTeamid() {
		return this.teamid;
	}

	public void setTeamid(Integer teamid) {
		this.teamid = teamid;
	}

	@Column(name = "team_name", length = 50)
	public String getTeamName() {
		return this.teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	@Column(name = "team_desc", length = 50)
	public String getTeamDesc() {
		return this.teamDesc;
	}

	public void setTeamDesc(String teamDesc) {
		this.teamDesc = teamDesc;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "team")
	public Set<TeamMember> getTeamMembers() {
		return this.teamMembers;
	}

	public void setTeamMembers(Set<TeamMember> teamMembers) {
		this.teamMembers = teamMembers;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "team")
	public Set<Project> getProjects() {
		return this.projects;
	}

	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}

}