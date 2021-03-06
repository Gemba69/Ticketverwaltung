package com.hsw.model;
// Generated 06.10.2015 23:10:36 by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * UserRoleId generated by hbm2java
 */
@Embeddable
public class UserRoleId implements java.io.Serializable {

	private String username;
	private String roleName;

	public UserRoleId() {
	}

	public UserRoleId(String username, String roleName) {
		this.username = username;
		this.roleName = roleName;
	}

	@Column(name = "Username", nullable = false, length = 40)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "Role_Name", nullable = false, length = 40)
	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof UserRoleId))
			return false;
		UserRoleId castOther = (UserRoleId) other;

		return ((this.getUsername() == castOther.getUsername()) || (this.getUsername() != null
				&& castOther.getUsername() != null && this.getUsername().equals(castOther.getUsername())))
				&& ((this.getRoleName() == castOther.getRoleName()) || (this.getRoleName() != null
						&& castOther.getRoleName() != null && this.getRoleName().equals(castOther.getRoleName())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getUsername() == null ? 0 : this.getUsername().hashCode());
		result = 37 * result + (getRoleName() == null ? 0 : this.getRoleName().hashCode());
		return result;
	}

}
