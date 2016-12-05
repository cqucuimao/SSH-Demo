package com.msober.domain.privilege;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Department {
	@Id
	@GeneratedValue
	private Long id;
	
	@OneToMany(mappedBy="department")		//由User对象的department属性来管理关联关系，相当于inverse=true
	private Set<User> users = new HashSet<User>();
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Department parent;
	
	@OneToMany(mappedBy="parent",cascade=CascadeType.REMOVE)
	private Set<Department> children = new HashSet<Department>();

	private String name;
	private String description;

	public Department getParent() {
		return parent;
	}

	public void setParent(Department parent) {
		this.parent = parent;
	}

	public Set<Department> getChildren() {
		return children;
	}

	public void setChildren(Set<Department> children) {
		this.children = children;
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
