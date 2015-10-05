package com.hsw.model;
// Generated 01.10.2015 14:24:38 by Hibernate Tools 4.0.0

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * RoleRight generated by hbm2java
 */
@Entity
@Table(name = "Role_Right", catalog = "ticketverwaltung")
public class RoleRight implements java.io.Serializable {

	private RoleRightId id;

	public RoleRight() {
	}

	public RoleRight(RoleRightId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "rightId", column = @Column(name = "Right_ID", nullable = false) ),
			@AttributeOverride(name = "roleId", column = @Column(name = "Role_ID", nullable = false) ) })
	public RoleRightId getId() {
		return this.id;
	}

	public void setId(RoleRightId id) {
		this.id = id;
	}

}
