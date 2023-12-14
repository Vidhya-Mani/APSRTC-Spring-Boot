package com.apsrtc.managebus.entity;



import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
