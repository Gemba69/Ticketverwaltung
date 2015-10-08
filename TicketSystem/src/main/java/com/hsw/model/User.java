package com.hsw.model;
// Generated 07.10.2015 21:18:52 by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.hsw.model.UserRole;

/**
 * User generated by hbm2java
 */
@Entity
@Table(name = "user", catalog = "ticketverwaltung", uniqueConstraints = @UniqueConstraint(columnNames = "email") )
public class User implements java.io.Serializable {

	private String username;
	private String passwort;
	private String email;
	private String vorname;
	private String nachname;
	private Set<UserRole> roles = new HashSet<UserRole>(0);
	private Set<Project> projects = new HashSet<Project>(0);
	private Set<Ticket> tickets = new HashSet<Ticket>(0);

	public User() {
	}

	public User(String username, String passwort, String email) {
		this.username = username;
		this.passwort = passwort;
		this.email = email;
	}

	public User(String username, String passwort, String email, String vorname, String nachname, Set<UserRole> roles, Set<Project> projects, Set<Ticket> tickets) {
		this.username = username;
		this.passwort = passwort;
		this.email = email;
		this.vorname = vorname;
		this.nachname = nachname;
		this.roles = roles;
		this.projects = projects;
		this.tickets = tickets;
	}

	@Id

	@Column(name = "username", unique = true, nullable = false, length = 40)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "passwort", nullable = false, length = 32)
	public String getPasswort() {
		return this.passwort;
	}

	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}

	@Column(name = "email", unique = true, nullable = false, length = 40)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "vorname", length = 40)
	public String getVorname() {
		return this.vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	@Column(name = "nachname", length = 40)
	public String getNachname() {
		return this.nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public Set<UserRole> getRoles() {
		return roles;
	}

	public void setRoles(Set<UserRole> roles) {
		this.roles = roles;
	}

//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "User")
//	public Set<Project> getProjects() {
//		return projects;
//	}
//
//	public void setProjects(Set<Project> projects) {
//		this.projects = projects;
//	}

//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "User")
//	public Set<Ticket> getTickets() {
//		return tickets;
//	}

	public void setTickets(Set<Ticket> tickets) {
		this.tickets = tickets;
	}
	
	

}
