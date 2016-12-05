package com.msober.install;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.msober.dao.privilege.PrivilegeDao;
import com.msober.dao.privilege.UserDao;
import com.msober.domain.privilege.Privilege;
import com.msober.domain.privilege.User;

/**
 * 安装程序（初始化数据）
 */
@Component
public class Installer {

	@Resource
	public SessionFactory sessionFactory;
	
	@Resource
	public UserDao userDao;
	
	@Resource 
	public PrivilegeDao privilegeDao;
	

	@Transactional
	public void install() {
		Session session = sessionFactory.getCurrentSession();
		// =======================================================================
		// 1，超级管理员
		User user = new User();
		user.setLoginName("admin");
		user.setName("超级管理员");
		user.setPassword(DigestUtils.md5Hex("admin")); // 密码要使用MD5摘要
		userDao.save(user); // 保存

		// =======================================================================
		// 2，权限数据
		Privilege menu, menu1, menu2, menu3, menu4, menu5;

		menu = new Privilege("系统管理", null, null);
		privilegeDao.save(menu);


		menu1 = new Privilege("角色管理", "/role_list", menu);
		privilegeDao.save(menu1);
		privilegeDao.save(new Privilege("角色删除", "/role_delete", menu1));
		privilegeDao.save(new Privilege("角色添加", "/role_add", menu1));
		privilegeDao.save(new Privilege("角色修改", "/role_edit", menu1));
		privilegeDao.save(new Privilege("角色设置权限", "/role_setPrivilege", menu1));

		menu2 = new Privilege("部门管理", "/department_list", menu);
		privilegeDao.save(menu2);
		privilegeDao.save(new Privilege("部门删除", "/department_delete", menu2));
		privilegeDao.save(new Privilege("部门添加", "/department_add", menu2));
		privilegeDao.save(new Privilege("部门修改", "/department_edit", menu2));

		
		menu3 = new Privilege("用户管理", "/user_list", menu);
		privilegeDao.save(menu3);
		privilegeDao.save(new Privilege("用户删除", "/user_delete", menu3));
		privilegeDao.save(new Privilege("用户添加", "/user_add", menu3));
		privilegeDao.save(new Privilege("用户修改", "/user_edit", menu3));
		privilegeDao.save(new Privilege("用户初始化密码", "/user_initPassword", menu3));


	}

	public static void main(String[] args) {
		System.out.println("正在初始化数据...");

		// 从Spring容器中取出对象
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		Installer installer = (Installer) ac.getBean("installer");
		// 执行安装
		installer.install();

		System.out.println("初始化数据完毕！");
	}

}
