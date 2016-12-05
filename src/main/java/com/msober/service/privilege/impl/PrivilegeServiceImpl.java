package com.msober.service.privilege.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msober.dao.privilege.PrivilegeDao;
import com.msober.domain.privilege.Privilege;
import com.msober.service.privilege.PrivilegeService;


@Service
public class PrivilegeServiceImpl implements PrivilegeService {

	@Autowired
	private PrivilegeDao privilegeDao;

	public List<Privilege> getAll() {
		return privilegeDao.getAll();
	}

	public void delete(Long id) {
		privilegeDao.delete(id);
	}

	public void save(Privilege privilege) {
		privilegeDao.save(privilege);
	}

	public Privilege getById(Long id) {
		return privilegeDao.getById(id);
	}

	public void update(Privilege privilege) {
		privilegeDao.update(privilege);
	}

	public List<Privilege> getByIds(Long[] privilegeIds) {
		return privilegeDao.getByIds(privilegeIds);
	}

	public Collection<String> getAllPrivilegeUrls() {
		Collection<String> allPrivilegeUrls = new ArrayList<String>();
		List<Privilege> all = getAll();
		
		for(Privilege p : all) {
			if(p.getUrl()!=null && !"".equals(p.getUrl())) {
				allPrivilegeUrls.add(p.getUrl());
			}
		}
		
		return allPrivilegeUrls;
		
	}
	


	
}
