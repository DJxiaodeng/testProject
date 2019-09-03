<%@page import="org.wsc.session1.entity.Office"%>
<%@page import="org.wsc.session1.dto.UserInfo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.wsc.session1.service.AdminUserService"%>
<%@ page language="java"  pageEncoding="utf-8"%>
<%
	
	String email = request.getParameter("email");
	String stat = request.getParameter("active");
	int active = Integer.parseInt(stat);
	
	AdminUserService adminService = new AdminUserService();
	
	boolean result = false;
	if(active == 1){
		//禁用
		result = adminService.disableUser(email);
	}else{
		//启用
		result = adminService.enableUser(email);
	}
	
	
	//进入管理员界面(请求转发:服务器跳转)
	request.getRequestDispatcher("doQueryByOffice.jsp").forward(request, response);
	
%>