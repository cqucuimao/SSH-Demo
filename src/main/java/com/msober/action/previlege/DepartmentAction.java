package com.msober.action.previlege;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.msober.action.common.BaseAction;
import com.msober.domain.common.PageBean;
import com.msober.domain.privilege.Department;
import com.msober.service.privilege.DepartmentService;
import com.msober.utils.QueryHelper;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
public class DepartmentAction extends BaseAction implements ModelDriven<Department> {

	private Department model = new Department();
	
	@Autowired
	private DepartmentService departmentService;
	
	

	public String list() throws Exception {
		QueryHelper helper = new QueryHelper(Department.class, "d");

		if (model.getName() != null && !"".equals(model.getName()))
			helper.addWhereCondition("d.name like ?", "%"+model.getName()+"%");
		
		PageBean pageBean = departmentService.getPageBean(pageNum, helper);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "list";
	}

	/** 列表 */
	public String delete() throws Exception {
		departmentService.delete(model.getId());
		return "toList";
	}

	/** 列表 */
	public String addUI() throws Exception {
		return "saveUI";
	}

	/** 列表 */
	public String add() throws Exception {
		// 保存到数据库
		System.out.println(model.getName());
		System.out.println(model.getDescription());
		departmentService.save(model);
		return "toList";
	}

	/** 列表 */
	public String editUI() throws Exception {
		// 准备回显的数据
		Department department = departmentService.getById(model.getId()); // 当前要修改的部门
		ActionContext.getContext().getValueStack().push(department);
		return "saveUI";
	}

	/** 列表 */
	public String edit() throws Exception {
		// 1，从数据库中取出要修改的原始数据
		Department department = departmentService.getById(model.getId());

		// 2，设置要修改的属性
		department.setName(model.getName());
		department.setDescription(model.getDescription());

		// 3，更新到数据库
		departmentService.update(department);
		return "toList";
	}

	public Department getModel() {
		// TODO Auto-generated method stub
		return null;
	}

}
