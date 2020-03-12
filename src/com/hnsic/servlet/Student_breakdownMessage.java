package com.hnsic.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hnsic.dao.StudentDao;
import com.hnsic.daoimpl.StudentDaoimpl;
import com.hnsic.entity.Repair;



public class Student_breakdownMessage extends HttpServlet {
	//学生申报故障
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			//接受表单提交过来的数据
			String repairID=request.getParameter("repairID");
			String time=request.getParameter("time");					
			String name=request.getParameter("name");
			String phone=request.getParameter("phone");
			String dormID=request.getParameter("dormID");
			String roomID=request.getParameter("roomID");
			String GZmiaoshu=request.getParameter("GZmiaoshu");
			
			//将数据装载到JavaBean
			Repair repair=new Repair();
			repair.setRepairID(repairID);
			repair.setTimes(time);
			repair.setName(name);
			repair.setPhone(phone);
			repair.setDormID(dormID);
			repair.setRoomID(roomID);
			repair.setGZmiaoshu(GZmiaoshu);
			
			//调用数据Dao层		
			StudentDao studentDao=new StudentDaoimpl();
			boolean flag=studentDao.add(repair);

			if(flag){
				response.sendRedirect("/dormitory/student/addsuccess.jsp");
			}else{
				response.sendRedirect("/dormitory/student/addfail.jsp");
		}
				
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
