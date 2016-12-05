package com.msober.service.privilege.impl;

import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msober.dao.privilege.UserDao;
import com.msober.domain.common.PageBean;
import com.msober.domain.privilege.User;
import com.msober.service.privilege.UserService;
import com.msober.utils.QueryHelper;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	public List<User> getByIds(Long[] ids) {
		return userDao.getByIds(ids);
	}

	public List<User> getAll() {
		return userDao.getAll();
	}

	public void delete(Long id) {
		userDao.delete(id);
	}

	public User getById(Long id) {
		return userDao.getById(id);
	}

	public void update(User user) {
		userDao.update(user);
	}

	public void save(User user) {
		// 默认密码是1234
		String md5 = DigestUtils.md5Hex("1234"); // 密码要使用MD5摘要
		user.setPassword(md5);

		// 保存到数据库
		userDao.save(user);
	}

	public User getByLoginNameAndPassword(String loginName, String password) {
		return userDao.getByLoginNameAndPassword(loginName, password);
	}

	
	public PageBean getPageBean(int pageNum, QueryHelper queryHelper) {
		return userDao.getPageBean(pageNum, queryHelper);
	}

	public User getByLoginName(String loginName) {
		return userDao.getByLoginName(loginName);
	}

}
