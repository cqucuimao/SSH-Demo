package com.msober.service.privilege;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.sql.SQLException;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.msober.base.BaseTest;
import com.msober.domain.common.PageBean;
import com.msober.domain.privilege.Customer;
import com.msober.utils.QueryHelper;

public class CustomerServiceTest extends BaseTest{
	
	@Autowired
	private CustomerService customerService;
	
	/**
	 * 判断spring是否初始化成功customerService
	 */
	@Test
	public void testInit() {
		assertNotNull(customerService);  
	}
	
	@Test 
	public void testGetById() throws SQLException, Exception {
	}
	
	@Test
    @DatabaseSetup({ "classpath:/data/privilege/customers_inserts.xml" }) 
	public void testDeleteById() {
		customerService.delete(4L);
		
		Customer c = customerService.getById(4L);
		assertNull(c);
	}
	
	
	@Test
    @DatabaseSetup({ "classpath:/data/privilege/customers_inserts.xml" })
	public void testUpdate() {
		Customer c = customerService.getById(2L);
		c.setName("xinmingzi");
		customerService.update(c);
		
		Customer c2 = customerService.getById(2L);
		assertEquals(c2.getName(), "xinmingzi2");
		
	}

	@Test
	@DatabaseSetup({ "classpath:/data/privilege/customers_inserts.xml" })
	public void testGetPageBean() {
		QueryHelper queryHelper = new QueryHelper(Customer.class, "c");
		PageBean pageBean1 = customerService.getPageBean(1, queryHelper);
		assertEquals(10, pageBean1.getRecordList().size());
		PageBean pageBean2 = customerService.getPageBean(2, queryHelper);
		assertEquals(3, pageBean2.getRecordList().size());
	}
}
