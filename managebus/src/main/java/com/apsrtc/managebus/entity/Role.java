package com.apsrtc.managebus.entity;

import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="role")
public class Role {
	@Id
	private String role;
    private String roleDescription;
    
	/*
	 * @ManyToMany(targetEntity = User.class,mappedBy = "roles",cascade =
	 * CascadeType.ALL) private List<User> users;
	 */
    
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getRoleDescription() {
		return roleDescription;
	}
	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}
	
	/*
	 * public List<User> getUsers() { return users; } public void
	 * setUsers(List<User> users) { this.users = users; }
	 */


}
