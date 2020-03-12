package com.hnsic.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hnsic.dao.AdminDao;
import com.hnsic.daoimpl.AdminDaoimpl;
import com.hnsic.entity.Grade;


public class Admin_allStudormGrade extends HttpServlet {
	//宿管员查询所有寝室成绩
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try{
			//新建操作对象
			AdminDao adminDao=new AdminDaoimpl();
			//调用查询方法
			List<Grade> list=adminDao.getAllgrade();
			//把数组放入会话中
			request.setAttribute("list10", list);
			System.out.println(list);
			request.getRequestDispatcher("/Admin/Admin_allStudormGrade.jsp").forward(request, response);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
