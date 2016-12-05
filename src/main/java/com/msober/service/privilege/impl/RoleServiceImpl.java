package com.msober.service.privilege.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msober.dao.privilege.RoleDao;
import com.msober.domain.common.PageBean;
import com.msober.domain.privilege.Role;
import com.msober.service.privilege.RoleService;
import com.msober.utils.QueryHelper;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDao roleDao;
	

	public List<Role> getAll() {
		return roleDao.getAll();
	}

	public void delete(Long id) {
		roleDao.delete(id);
		
	}

	public void save(Role role) {
		roleDao.save(role);
		
	}

	public Role getById(Long id) {
		return roleDao.getById(id);
	}

	public void update(Role role) {
		roleDao.update(role);
	}

	public List<Role> getByIds(Long[] ids) {
		// TODO Auto-generated method stub
		return roleDao.getByIds(ids);
	}

	
	public PageBean getPageBean(int pageNum, QueryHelper queryHelper) {		
		return roleDao.getPageBean(pageNum, queryHelper);
	}
	
}
