package com.msober.action.previlege;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.msober.action.common.BaseAction;
import com.msober.domain.privilege.User;
import com.msober.service.privilege.PrivilegeService;
import com.msober.service.privilege.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
public class LoginAction extends BaseAction implements ModelDriven<User>{

	private User model = new User();
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PrivilegeService privilegeService;
	
	
	/** 登录页面 */
	public String loginUI() throws Exception {
		return "loginUI";
	}

	/** 登录 */
	public String login() throws Exception {
		
		System.out.println("model.getName:"+model.getName());
		
		// 验证用户名与密码，如果正确就返回这个用户，否则返回null
		User user = userService.getByLoginNameAndPassword(model.getLoginName(), model.getPassword());
		
		// 如果登录名或密码不正确，就转回到登录页面并提示错误消息
		if (user == null) {
			addFieldError("loginError", "登录名或密码不正确！");
			return "loginUI";
		}
		// 如果登录名与密码都正确，就登录用户
		else {
			ActionContext.getContext().getSession().put("user", user);
			ActionContext.getContext().getSession().put("allPrivileges", privilegeService.getAllPrivilegeUrls());
			return "toHome";
		}
	}

	/** 注销 */
	public String logout() throws Exception {
		ActionContext.getContext().getSession().remove("user");
		return "logout";
	}

	public User getModel() {
		// TODO Auto-generated method stub
		return model;
	}

}
