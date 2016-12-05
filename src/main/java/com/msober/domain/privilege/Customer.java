
package com.msober.domain.privilege;

import java.io.Serializable;

import javax.persistence.Entity;

import com.msober.domain.common.BaseEntity;

@Entity
public class Customer extends BaseEntity implements Serializable{
	
	private String name;//客户姓名
	private String gender;//性别
	private String phoneNumber;//电话
	private String description; // 说明
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
	

}
