package com.msober.dao.privilege.impl;

import org.springframework.stereotype.Repository;

import com.msober.dao.common.impl.BaseDaoImpl;
import com.msober.dao.privilege.UserDao;
import com.msober.domain.privilege.User;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{

	public User getByLoginName(String loginName) {
		if(StringUtils.isEmpty(loginName)) {
			return null;
		}
		
		return (User)getSession().createQuery("from User u where u.loginName=?")//
					.setParameter(0, loginName).uniqueResult();
	}

	public User getByLoginNameAndPassword(String loginName, String password) {
		if(loginName == null || password == null) return null;
		String md5 = DigestUtils.md5Hex(password);
		return (User) getSession().createQuery(//
				"FROM User u WHERE u.loginName=? AND u.password=?")//
				.setParameter(0, loginName)//
				.setParameter(1, md5)// 密码要使用MD5摘要
				.uniqueResult();
	}
	
}
