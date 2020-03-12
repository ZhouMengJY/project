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

public class Sysadmin_modifypassword extends HttpServlet {
	//系统管理员修改密码
	
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//设置编码方式
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		//使用ALTER弹出提示信息，防止乱码。
		String CONTENT_TYPE = "text/html; charset=GBK";
		response.setContentType(CONTENT_TYPE);			
		PrintWriter out=response.getWriter();     //初始化out对象
		
		//获取表单提交过来的密码信息
		String password=request.getParameter("password");
		String passwordAgain=request.getParameter("passwordAgain");
		
		//获取存放在session中的sysadminID
		HttpSession session=request.getSession();
		Sysadmin sysadmin =(Sysadmin)session.getAttribute("sysadmin");			
				
		try{
			if(password.equals(passwordAgain)){	
				System.out.println(password);
				System.out.println(passwordAgain);
				sysadmin.setPassword(password);
				SysadminDao sysadminDao=new SysadminDaoimpl();
				boolean flag=sysadminDao.modifypassword(sysadmin);
				if(flag){
					//跳转到changeSuccess.jsp
					request.getRequestDispatcher("Sysadmin/sysadmin_modifypwddSuccess.jsp").forward(request, response);
					
				}else{
					System.out.println("未知错误");
				}			
			
			}else{
				out.print("<script language='javascript'>alert('二次密码不一致!!');window.location.href='/dormitory/Sysadmin/sysadmin_modifypassword.jsp';</script>");					
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
