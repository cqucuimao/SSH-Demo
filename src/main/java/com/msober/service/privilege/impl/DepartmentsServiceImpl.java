package com.msober.service.privilege.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msober.dao.privilege.DepartmentDao;
import com.msober.domain.common.PageBean;
import com.msober.domain.privilege.Department;
import com.msober.service.privilege.DepartmentService;
import com.msober.utils.QueryHelper;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Service
public class DepartmentsServiceImpl implements DepartmentService {

	@Autowired
	DepartmentDao departmentDao;
	
	public List<Department> getAll() {
		return departmentDao.getAll();
	}

	public void delete(Long id) {
		departmentDao.delete(id);
	}

	public void save(Department department) {
		departmentDao.save(department);
	}

	public Department getById(Long id) {
		return departmentDao.getById(id);
	}

	public void update(Department department) {
		departmentDao.update(department);
		
	}

	public List<Department> findChildren(Long parentId) {
		return departmentDao.findChildren(parentId);
	}

	public List<Department> findTopList() {
		return departmentDao.findTopList();
	}

	public PageBean getPageBean(int pageNum, QueryHelper queryHelper) {
		return departmentDao.getPageBean(pageNum, queryHelper);
	}



}
