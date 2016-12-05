package com.msober.domain.privilege;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


/**
 * 岗位
 * 
 * @author tyg
 * 
 */
@Entity
public class Role {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String description;
	
	@ManyToMany(mappedBy="roles" )
	private Set<User> users = new HashSet<User>();
	
	@ManyToMany(fetch=FetchType.EAGER)
	private Set<Privilege> privileges = new HashSet<Privilege>();
	
	
	public Set<Privilege> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(Set<Privilege> privileges) {
		this.privileges = privileges;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
