package com.hnsic.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hnsic.dao.InstructorDao;
import com.hnsic.daoimpl.InstructorDaoimpl;
import com.hnsic.entity.Student;

public class Instructor_queryallstudent extends HttpServlet {
	//查询所有同班级的学生
	
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//设置编码方式
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String classes=request.getParameter("classes");
		try{
			//新建操作对象
			InstructorDao instructorDao=new InstructorDaoimpl();
			//调用查询方法
			List<Student> list=instructorDao.getallstudent(classes);
			//把数组放入会话中
			request.setAttribute("list21", list);
			
			System.out.println(list);
			
			request.getRequestDispatcher("instructor/Instructor_queryallstudent.jsp").forward(request, response);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
