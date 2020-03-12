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
import com.hnsic.entity.Absent;

public class Admin_queryAbsent extends HttpServlet {	
	//查询学生缺寝情况
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try{	
			AdminDao adminDAo=new AdminDaoimpl();
			List<Absent> list=adminDAo.getAbsent();
			
			HttpSession session=request.getSession();
			session.setAttribute("list8", list);
			response.sendRedirect("Admin/Admin_absentStudent.jsp");
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
