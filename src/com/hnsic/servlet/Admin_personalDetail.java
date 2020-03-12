package com.hnsic.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hnsic.dao.AdminDao;
import com.hnsic.daoimpl.AdminDaoimpl;
import com.hnsic.entity.Admin;

public class Admin_personalDetail extends HttpServlet {		
	//查询个人信息
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");	
		
		//获取存放在session中的InstructorID
		Admin admin=(Admin)session.getAttribute("admin");
		String adminID=admin.getAdminID();
		System.out.println(adminID);
		
		try{			
			//新建操作对象
			AdminDao adminDao=new AdminDaoimpl();
			//调用查询方法
			List<Admin> list=adminDao.getAdmin(adminID);
			//把数组放入会话中
			request.setAttribute("list11", list);
			request.getRequestDispatcher("Admin/Admin_personalDetail.jsp").forward(request, response);
		}catch(Exception e){
			e.printStackTrace();
		}
	
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doGet(request,response);
	}

}
