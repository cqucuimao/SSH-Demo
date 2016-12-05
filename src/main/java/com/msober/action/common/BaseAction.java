package com.msober.action.common;

import java.lang.reflect.ParameterizedType;

import javax.annotation.Resource;

import com.msober.service.privilege.DepartmentService;
import com.msober.service.privilege.RoleService;
import com.msober.service.privilege.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public abstract class BaseAction extends ActionSupport{

	public BaseAction() {
	
	}

	protected int pageNum = 1; // 当前页，默认为第1页

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
}
