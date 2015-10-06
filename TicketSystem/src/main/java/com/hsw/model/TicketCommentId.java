package com.hsw.model;
// Generated 06.10.2015 15:00:23 by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * TicketCommentId generated by hbm2java
 */
@Embeddable
public class TicketCommentId implements java.io.Serializable {

	private int commentId;
	private int ticketId;

	public TicketCommentId() {
	}

	public TicketCommentId(int commentId, int ticketId) {
		this.commentId = commentId;
		this.ticketId = ticketId;
	}

	@Column(name = "Comment_ID", nullable = false)
	public int getCommentId() {
		return this.commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	@Column(name = "TicketID", nullable = false)
	public int getTicketId() {
		return this.ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TicketCommentId))
			return false;
		TicketCommentId castOther = (TicketCommentId) other;

		return (this.getCommentId() == castOther.getCommentId()) && (this.getTicketId() == castOther.getTicketId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getCommentId();
		result = 37 * result + this.getTicketId();
		return result;
	}

}
