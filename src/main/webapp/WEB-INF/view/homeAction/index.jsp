<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%-- 显示数据 --%>
<html>
	<body>
		
		<h3>欢迎您！ <s:property value="#session.user.loginName"/></h3>
		<s:a action="login_logout">注销</s:a>
		<ul>
			<li>
				<s:a action="user_list">用户管理</s:a>
				<s:a action="department_list">部门管理</s:a>
				<s:a action="role_list">角色管理</s:a>
			</li><br>
			<li><s:a action="customer_list">客户管理</s:a></li>
		</ul>
	</body>
</html>

<s:debug>
</s:debug>