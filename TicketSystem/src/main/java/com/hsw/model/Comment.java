package com.hsw.model;
// Generated 11.10.2015 00:41:08 by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Comment generated by hbm2java
 */
@Entity
@Table(name = "Comment", catalog = "ticketverwaltung")
public class Comment implements java.io.Serializable {

	private Integer commentId;
	private Ticket ticket;
	private User user;
	private String comment;

	public Comment() {
	}

	public Comment(Ticket ticket, String comment) {
		this.ticket = ticket;
		this.comment = comment;
	}

	public Comment(Ticket ticket, User user, String comment) {
		this.ticket = ticket;
		this.user = user;
		this.comment = comment;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "Comment_ID", unique = true, nullable = false)
	public Integer getCommentId() {
		return this.commentId;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "Project_Code", referencedColumnName = "project_code"),
			@JoinColumn(name = "Ticket_ID", referencedColumnName = "Ticket_ID", nullable = false) })
	public Ticket getTicket() {
		return this.ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Comment_Issuer")
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "Comment", nullable = false, length = 200)
	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
