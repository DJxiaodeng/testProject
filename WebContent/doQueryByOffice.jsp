<%@page import="org.wsc.session1.entity.Office"%>
<%@page import="org.wsc.session1.dto.UserInfo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.wsc.session1.service.AdminUserService"%>
<%@ page language="java"  pageEncoding="utf-8"%>
<%

	//获取需要查询的officeID
	String officeID = request.getParameter("officeID");
	officeID = officeID == null ? "0" : officeID;
	
	AdminUserService adminService = new AdminUserService();
	ArrayList<Office> offices = adminService.queryAllOffice();
	ArrayList<UserInfo> users = null;
	if("0".equals(officeID)){
		//查所有
		users = adminService.findAllUsers();
	}else{
		//差指定id
		users = adminService.findByOffice(officeID);
	}
	
	//将需要显示的数据传递到下一个页面
	request.setAttribute("users", users);
	request.setAttribute("offices", offices);
	request.setAttribute("officeID", officeID);
	//进入管理员界面(请求转发:服务器跳转)
	request.getRequestDispatcher("4.jsp").forward(request, response);

%>