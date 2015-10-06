package com.hsw.model;
// Generated 06.10.2015 15:00:23 by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * StatusTyp generated by hbm2java
 */
@Entity
@Table(name = "Status_Typ", catalog = "ticketverwaltung")
public class StatusTyp implements java.io.Serializable {

	private Integer statusId;
	private String status;
	private String statusDesc;

	public StatusTyp() {
	}

	public StatusTyp(String status) {
		this.status = status;
	}

	public StatusTyp(String status, String statusDesc) {
		this.status = status;
		this.statusDesc = statusDesc;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "Status_ID", unique = true, nullable = false)
	public Integer getStatusId() {
		return this.statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	@Column(name = "Status", nullable = false, length = 30)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "Status_Desc", length = 50)
	public String getStatusDesc() {
		return this.statusDesc;
	}

	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}

}
