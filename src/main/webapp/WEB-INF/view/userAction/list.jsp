<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
<head>
    <title>用户列表</title>
    <%@ include file="/WEB-INF/view/public/header.jspf" %>
</head>
<body>
<h2>用户管理</h2>
<hr />
<div>
    <table cellspacing="0" cellpadding="0">
       
        <!-- 表头-->
        <thead>
            <tr>
                <td width="100">登录名</td>
                <td width="100">姓名</td>
                <td width="100">所属部门</td>
                <td width="200">岗位</td>
                <td>备注</td>
                <td>相关操作</td>
            </tr>
        </thead>
        
        <!--显示数据列表-->
        <tbody>
        
        <s:iterator value="recordList">
            <tr class="TableDetail1 template">
                <td>${loginName}&nbsp;</td>
                <td>${name}&nbsp;</td>
                <td>${department.name}&nbsp;</td>
                <td>
                	<s:iterator value="roles">
                		${name}
                	</s:iterator>&nbsp;
                </td>
                <td>${description}&nbsp;</td>
                <td>
                	<s:a action="user_delete?id=%{id}" onclick="return delConfirm()">删除</s:a>
                    <s:a action="user_editUI?id=%{id}">修改</s:a>
                </td>
            </tr>
        </s:iterator> 
            
        </tbody>
    </table>
    
    <!-- 其他功能超链接 -->
    <div>
    	<s:a action="user_addUI">增加用户</s:a>
    </div>
</div>
<hr />
<%-- 分页信息 --%>
<s:form id="pageForm" action="user_list"></s:form>
<%@ include file="/WEB-INF/view/public/pageView.jspf" %>


<s:debug></s:debug>
</body>
</html>
