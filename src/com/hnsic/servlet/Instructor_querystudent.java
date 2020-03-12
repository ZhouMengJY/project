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

public class Instructor_querystudent extends HttpServlet {		//查询学生

	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String stuID=request.getParameter("stuID");
		try{
			System.out.println(stuID);
			//新建操作对象
			InstructorDao instructorDao=new InstructorDaoimpl();
			//调用查询方法
			List<Student> list=instructorDao.getstudent(stuID);
			//把数组放入会话中
			request.setAttribute("list4", list);
//			request.getRequestDispatcher("instructor/Instructor_querysuccess.jsp").forward(request, response);
			request.getRequestDispatcher("instructor/Instructor_querystudent.jsp").forward(request, response);
		}catch(Exception e){
			e.printStackTrace();
		}
			
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
