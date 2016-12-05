package com.msober.service.privilege;

import java.util.List;

import com.msober.domain.common.PageBean;
import com.msober.domain.privilege.Customer;
import com.msober.service.base.BaseService;
import com.msober.utils.QueryHelper;

public interface CustomerService extends BaseService{

	/**
	 * 查询所有的客户信息
	 * @return
	 */
	List<Customer> getAll();

	/**
	 * 删除用户信息
	 * @param id
	 */
	void delete(Long id);

	/**
	 * 保存
	 * @param role
	 */
	void save(Customer customer);

	/**
	 * 获取
	 * @param id
	 * @return
	 */
	Customer getById(Long id);

	/**
	 * 更新
	 * @param role
	 */
	void update(Customer customer);
	
	List<Customer> getByIds(Long ids[]);
	
	PageBean getPageBean( int pageNum , QueryHelper helper);
}
