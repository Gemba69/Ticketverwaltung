package com.hsw.model;
// Generated 11.10.2015 00:41:08 by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Project generated by hbm2java
 */
@Entity
@Table(name = "project", catalog = "ticketverwaltung", uniqueConstraints = @UniqueConstraint(columnNames = "project_name") )
public class Project implements java.io.Serializable {

	private String projectCode;
	private User user;
	private String projectName;
	private String projectDesc;
	private int projectCounter;

	public Project() {
	}

	public Project(String projectCode, User user, String projectName, int projectCounter) {
		this.projectCode = projectCode;
		this.user = user;
		this.projectName = projectName;
		this.projectCounter = projectCounter;
	}

	public Project(String projectCode, User user, String projectName, String projectDesc, int projectCounter) {
		this.projectCode = projectCode;
		this.user = user;
		this.projectName = projectName;
		this.projectDesc = projectDesc;
		this.projectCounter = projectCounter;
	}

	@Id

	@Column(name = "project_code", unique = true, nullable = false, length = 5)
	public String getProjectCode() {
		return this.projectCode;
	}

	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "project_owner", nullable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "project_name", unique = true, nullable = false, length = 40)
	public String getProjectName() {
		return this.projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	@Column(name = "project_desc", length = 40)
	public String getProjectDesc() {
		return this.projectDesc;
	}

	public void setProjectDesc(String projectDesc) {
		this.projectDesc = projectDesc;
	}

	@Column(name = "project_counter", nullable = false)
	public int getProjectCounter() {
		return this.projectCounter;
	}

	public void setProjectCounter(int projectCounter) {
		this.projectCounter = projectCounter;
	}

}
