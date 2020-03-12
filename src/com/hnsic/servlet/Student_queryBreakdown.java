package com.hnsic.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.hnsic.dao.StudentDao;
import com.hnsic.daoimpl.StudentDaoimpl;
import com.hnsic.entity.Repair;


public class Student_queryBreakdown extends HttpServlet {
	//查询故障信息
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			try{
				//新建操作对象
				StudentDao studentDao=new StudentDaoimpl();
				
				//调用查询方法
				List<Repair> list=studentDao.getAllRepair();
						
				//把数组放入会话中
				//request.setAttribute("list", list);
				//request.getRequestDispatcher("/dormitory/student/looksmessage.jsp").forward(request, response);
			
				HttpSession session=request.getSession();
				session.setAttribute("list3", list);
				response.sendRedirect("/dormitory/student/looksmessage.jsp");
			}catch(Exception e){
				e.printStackTrace();
			}

	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doGet(request,response);
		
	}

}
