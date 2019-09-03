<%@page import="org.wsc.session1.entity.Office"%>
<%@page import="org.wsc.session1.dto.UserInfo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.wsc.session1.service.AdminUserService"%>
<%@page import="org.wsc.session1.dto.Model"%>
<%@page import="org.wsc.session1.entity.User"%>
<%@page import="org.wsc.session1.service.UserService"%>
<%@ page language="java"  pageEncoding="utf-8"%>
<%

	String name = request.getParameter("username");
	String pwd = request.getParameter("password");
	
	User user = new User();
	user.setEmail(name);
	user.setPassword(pwd);
	
	UserService userService = new UserService();
	Model model = userService.login(user);
	if(model.isSuccess()){
		//账号密码正确（根据不同的角色进入不同页面）
		Object obj = model.getData();
		User u = (User)obj;
		if(u.getRole().equals("administrator")){
			//进入管理员界面(请求转发:服务器跳转)
			request.getRequestDispatcher("doQueryByOffice.jsp").forward(request, response);
		}else{
			//进入普通用户界面(重定向:客户端跳转)
			response.sendRedirect("6.html");
		}
	}else{
		out.println("<script>alert('"+model.getMsg()+"');history.back();</script>");
	}
	
%>