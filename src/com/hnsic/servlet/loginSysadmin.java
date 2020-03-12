package com.hnsic.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hnsic.dao.SysadminDao;
import com.hnsic.daoimpl.SysadminDaoimpl;
import com.hnsic.entity.Sysadmin;

public class loginSysadmin extends HttpServlet {
	//系统管理员登录
	
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//接受表单提交过来的数据
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String UserName=request.getParameter("username");
		String password=request.getParameter("password");
		//使用ALTER弹出提示信息，防止乱码。
		String CONTENT_TYPE = "text/html; charset=GBK";
		response.setContentType(CONTENT_TYPE);			
		PrintWriter out=response.getWriter();     //初始化out对象
		
		//把数据装载到Javabean
		Sysadmin sysadmin=new Sysadmin();
		sysadmin.setSysadminID(UserName);
		sysadmin.setPassword(password);
							
		SysadminDao sysadminDao=new SysadminDaoimpl();
		
		System.out.println(UserName);
		System.out.println(password);
		
		boolean flag=sysadminDao.Login(sysadmin);
		
		//应用 session保存bean信息		
		HttpSession session=request.getSession();
		session.setAttribute("sysadmin",sysadmin);
		
		//登录成功则转发到系统页面，错误则提示错误信息。
		if(flag){
			response.sendRedirect("/dormitory/SysadminMainPage.html");  
			}else{					
				if(sysadmin.getRemarks().equals("1")){
					out.print("<script language='javascript'>alert('密码错误!!');window.location.href='/dormitory/SysadminLoginPage.html';</script>");   
				}
				else{
					out.print("<script language='javascript'>alert('用户名不存在!!');window.location.href='/dormitory/SysadminLoginPage.html';</script>");            
				}				
			}
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
