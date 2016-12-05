<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
<head>
    <title>客户列表</title>
    <%@ include file="/WEB-INF/view/public/header.jspf" %>
</head>
<body>
<h2>客户管理</h2>
<hr />

<s:form id="pageForm" action="customer_list">
搜索客户：<s:textfield size="20" cssClass="TextField" name="name" />
<s:submit/>
</s:form>

<div>
    <table cellspacing="0" cellpadding="0">
       
        <!-- 表头-->
        <thead>
            <tr>
                <td width="100">姓名</td>
                <td width="100">性别</td>
                <td width="100">电话</td>
                <td width="100">备注</td>
                <td width="100">相关操作</td>
            </tr>
        </thead>
        
        <!--显示数据列表-->
        <tbody>
        
        <s:iterator value="recordList">
            <tr class="TableDetail1 template">
                <td>${name}&nbsp;</td>
                <td>${gender}&nbsp;</td>
                <td>${phoneNumber}&nbsp;</td>
                <td>${description}&nbsp;</td>
                <td>
                	<s:a action="customer_delete?id=%{id}" onclick="return delConfirm()">删除</s:a>
                    <s:a action="customer_editUI?id=%{id}">修改</s:a>
                </td>
            </tr>
        </s:iterator> 
            
        </tbody>
    </table>
    
    <!-- 其他功能超链接 -->
    <div>
    	<s:a action="customer_addUI">增加用户</s:a>
    </div>
</div>
<hr />
<%-- 分页信息 --%>
<s:form id="pageForm" action="customer_list"></s:form>
<%@ include file="/WEB-INF/view/public/pageView.jspf" %>


<s:debug></s:debug>
</body>
</html>
