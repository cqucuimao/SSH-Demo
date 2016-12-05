package com.msober.service.privilege.impl;

import java.util.List;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.msober.dao.privilege.CustomerDao;
import com.msober.domain.common.PageBean;
import com.msober.domain.privilege.Customer;
import com.msober.service.privilege.CustomerService;
import com.msober.utils.QueryHelper;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerDao customerDao;
	
	public List<Customer> getByIds(Long[] ids) {
		return customerDao.getByIds(ids);
	}

	public List<Customer> getAll() {
		return customerDao.getAll();
	}

	public void delete(Long id) {
		customerDao.delete(id);
	}

	public Customer getById(Long id) {
		return customerDao.getById(id);
	}

	public void update(Customer customer) {
		customerDao.update(customer);
	}

	public void save(Customer customer) {

		// 保存到数据库
		customerDao.save(customer);
	}

	public Customer findByLoginNameAndPassword(String loginName, String password) {
		if(loginName == null || password == null) return null;
		String md5 = DigestUtils.md5Hex(password);
		return (Customer) customerDao.getSession().createQuery(//
				"FROM User u WHERE u.loginName=? AND u.password=?")//
				.setParameter(0, loginName)//
				.setParameter(1, md5)// 密码要使用MD5摘要
				.uniqueResult();
	}

	
	public PageBean getPageBean(int pageNum, QueryHelper queryHelper) {
		return customerDao.getPageBean(pageNum, queryHelper);
	}
}
