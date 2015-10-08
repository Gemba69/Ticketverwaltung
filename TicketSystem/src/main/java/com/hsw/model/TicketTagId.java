package com.hsw.model;
// Generated 07.10.2015 21:18:52 by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * TicketTagId generated by hbm2java
 */
@Embeddable
public class TicketTagId implements java.io.Serializable {

	private String projectCode;
	private int ticketId;
	private String tagName;

	public TicketTagId() {
	}

	public TicketTagId(String projectCode, int ticketId, String tagName) {
		this.projectCode = projectCode;
		this.ticketId = ticketId;
		this.tagName = tagName;
	}

	@Column(name = "Project_Code", nullable = false, length = 5)
	public String getProjectCode() {
		return this.projectCode;
	}

	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

	@Column(name = "Ticket_ID", nullable = false)
	public int getTicketId() {
		return this.ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	@Column(name = "Tag_Name", nullable = false, length = 20)
	public String getTagName() {
		return this.tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TicketTagId))
			return false;
		TicketTagId castOther = (TicketTagId) other;

		return ((this.getProjectCode() == castOther.getProjectCode()) || (this.getProjectCode() != null
				&& castOther.getProjectCode() != null && this.getProjectCode().equals(castOther.getProjectCode())))
				&& (this.getTicketId() == castOther.getTicketId())
				&& ((this.getTagName() == castOther.getTagName()) || (this.getTagName() != null
						&& castOther.getTagName() != null && this.getTagName().equals(castOther.getTagName())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getProjectCode() == null ? 0 : this.getProjectCode().hashCode());
		result = 37 * result + this.getTicketId();
		result = 37 * result + (getTagName() == null ? 0 : this.getTagName().hashCode());
		return result;
	}

}
