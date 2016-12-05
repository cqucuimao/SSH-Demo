package com.msober.domain.privilege;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.msober.domain.common.BaseEntity;
import com.opensymphony.xwork2.ActionContext;

@Entity
public class User extends BaseEntity implements Serializable {
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name = "user_role", joinColumns = { @JoinColumn(name = "user_id")},
		inverseJoinColumns = { @JoinColumn(name = "role_id") })
	private Set<Role> roles = new HashSet<Role>();
	
	@ManyToOne(fetch=FetchType.LAZY )
	private Department department;
	
	@Temporal(TemporalType.DATE)	//保存时间
	private Date birth;
	
	
	private String loginName; // 登录名
	private String password; // 密码
	private String name; // 真实姓名
	private String gender; // 性别
	private String phoneNumber; // 电话号码
	private String email; // 电子邮件
	private String description; // 说明
	
	

	/**
	 * 判断当前用户是否是超级管理员
	 */
	public boolean isAdmin() {
		return "admin".equals(loginName);
	}
	
	
	/**
	 * 判断当前用户是否有指定URL的权限
	 * 
	 * @param privUrl
	 *            权限的URL
	 * @return
	 */
	public boolean hasPrivilegeByUrl(String privUrl) {
		
		// 如果是超级管理员，就有所有的权限
		if (isAdmin()) {
			return true;
		}

		// 获取访问的路径
		int pos = privUrl.indexOf("?");
		if (pos > -1) {
			privUrl = privUrl.substring(0, pos);
		}
		if (privUrl.endsWith("UI")) {
			privUrl = privUrl.substring(0, privUrl.length() - 2);
		}

		// 普通用户判断权限
		Collection<String> allPrivilegeUrls =(Collection<String>) ActionContext.getContext().getSession().get("allPrivileges");
		System.out.println(privUrl);
		System.out.println(allPrivilegeUrls.size());
		if (!allPrivilegeUrls.contains(privUrl)) {	//用户公有权限
			System.out.println("没有包括");
			return true;
		}
		
		// 该Url需要权限访问控制
		else {
			for (Role role : roles) {
				for (Privilege p : role.getPrivileges()) {
					if (privUrl.equals(p.getUrl())) {
						System.out.println(p.getName());
						return true;
					}
				}
			}
			return false;
		}
		
	}

	
	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

}
