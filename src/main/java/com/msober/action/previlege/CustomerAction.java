package com.msober.action.previlege;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.msober.action.common.BaseAction;
import com.msober.domain.common.PageBean;
import com.msober.domain.privilege.Customer;
import com.msober.domain.privilege.User;
import com.msober.service.privilege.CustomerService;
import com.msober.utils.QueryHelper;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
public class CustomerAction extends BaseAction implements ModelDriven<Customer>{
	
	private Customer model = new Customer();
	
	@Autowired
	private CustomerService customerService;

	/** 列表 */
	public String list() throws Exception {
		QueryHelper helper = new QueryHelper(Customer.class, "c");

		if(model.getName()!=null && !"".equals(model.getName()))
			helper.addWhereCondition("c.name=?", model.getName());
		PageBean pageBean = customerService.getPageBean(pageNum, helper);
		
		ActionContext.getContext().getValueStack().push(pageBean);
		return "list";
	}
	/** 删除 */
	public String delete() throws Exception {
		customerService.delete(model.getId());
		return "toList";
	}

	/** 添加页面 */
	public String addUI() throws Exception {
		

		return "saveUI";
	}

	/** 添加 */
	public String add() throws Exception {

		// 保存到数据库
		customerService.save(model);

		return "toList";
	}

	/** 修改页面 */
	public String editUI() throws Exception {
		// 准备回显的数据
		Customer customer = customerService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(customer);
		
		return "saveUI";
	}

	/** 修改 */
	public String edit() throws Exception {
		//从数据库中取出原对象
		Customer customer = customerService.getById(model.getId());

		//设置要修改的属性
		customer.setName(model.getName());
		customer.setGender(model.getGender());
		customer.setPhoneNumber(model.getPhoneNumber());
		customer.setDescription(model.getDescription());
		//更新到数据库
		customerService.update(customer);

		return "toList";
	}
	public Customer getModel() {
		// TODO Auto-generated method stub
		return model;
	}


}
