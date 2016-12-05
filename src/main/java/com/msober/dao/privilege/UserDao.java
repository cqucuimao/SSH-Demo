package com.msober.dao.privilege;

import com.msober.dao.common.BaseDao;
import com.msober.domain.privilege.User;

public interface UserDao extends BaseDao<User>{
	public User getByLoginName(String loginName);
	public User getByLoginNameAndPassword(String loginName, String password);
	
}
