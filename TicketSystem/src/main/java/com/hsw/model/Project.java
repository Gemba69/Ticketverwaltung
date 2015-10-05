package com.hsw.model;
// Generated 01.10.2015 14:24:38 by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Project generated by hbm2java
 */
@Entity
@Table(name = "Project", catalog = "ticketverwaltung")
public class Project implements java.io.Serializable {

	private Integer projectId;
	private String projectName;
	private String projectCode;
	private String projectDesc;
	private String projectOwner;

	public Project() {
	}

	public Project(String projectCode, String projectOwner) {
		this.projectCode = projectCode;
		this.projectOwner = projectOwner;
	}

	public Project(String projectName, String projectCode, String projectDesc, String projectOwner) {
		this.projectName = projectName;
		this.projectCode = projectCode;
		this.projectDesc = projectDesc;
		this.projectOwner = projectOwner;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "Project_ID", unique = true, nullable = false)
	public Integer getProjectId() {
		return this.projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	@Column(name = "Project_Name", length = 30)
	public String getProjectName() {
		return this.projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	@Column(name = "Project_Code", nullable = false, length = 5)
	public String getProjectCode() {
		return this.projectCode;
	}

	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

	@Column(name = "Project_Desc", length = 80)
	public String getProjectDesc() {
		return this.projectDesc;
	}

	public void setProjectDesc(String projectDesc) {
		this.projectDesc = projectDesc;
	}

	@Column(name = "Project_Owner", nullable = false, length = 40)
	public String getProjectOwner() {
		return this.projectOwner;
	}

	public void setProjectOwner(String projectOwner) {
		this.projectOwner = projectOwner;
	}

}
