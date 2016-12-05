package com.msober.service.privilege;

import java.util.Collection;
import java.util.List;

import com.msober.domain.privilege.Privilege;
import com.msober.service.base.BaseService;

public interface PrivilegeService extends BaseService {

	List<Privilege> getAll();

	void delete(Long id);

	void save(Privilege privilege);

	Privilege getById(Long id);

	void update(Privilege privilege);

	List<Privilege> getByIds(Long[] privilegeIds);
	
	Collection<String> getAllPrivilegeUrls();
}
