package com.hnsic.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hnsic.dao.SysadminDao;
import com.hnsic.daoimpl.SysadminDaoimpl;
import com.hnsic.entity.Student;

public class Sysadmin_addstudent extends HttpServlet {
	//系统管理员添加学生
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
		//接受表单提交过来的数据
		String stuID=request.getParameter("stuID");
		String password=request.getParameter("password");
		String name=request.getParameter("name");
		String sex=request.getParameter("sex");
		String dormID=request.getParameter("dormID");
		String roomID=request.getParameter("roomID");
		String xueyuan=request.getParameter("xueyuan");
		String major=request.getParameter("major");
		String classes=request.getParameter("classes");
		String phone=request.getParameter("phone");
		String birthday=request.getParameter("birthday");
		String remarks=request.getParameter("remarks");
		//将数据装载到JavaBean
		Student student=new Student();
		student.setStuID(stuID);
		student.setPassword(password);
		student.setName(name);
		student.setSex(sex);
		student.setDormID(dormID);
		student.setRoomID(roomID);
		student.setXueyuan(xueyuan);
		student.setMajor(major);
		student.setClasses(classes);
		student.setPhone(phone);
		student.setBirthday(birthday);
		student.setRemarks(remarks);
		//调用数据Dao层
		SysadminDao sysadminDao=new SysadminDaoimpl();
		boolean flag=sysadminDao.addstudent(student);
		if(flag){
//			response.sendRedirect("/dormitory/Sysadmin/sysadmin_stuaddsuccess.jsp");
			out.print("<script language='javascript'>alert('添加学生成功!!!');" +
					"window.location.href='/dormitory/Sysadmin/sysadmin_addstudent.jsp';</script>");
		}else{
//			response.sendRedirect("/dormitory/Sysadmin/sysadmin_stuaddfail.jsp");
			out.print("<script language='javascript'>alert('添加学生失败，请重新添加!!!');" +
					"window.location.href='/dormitory/Sysadmin/sysadmin_addstudent.jsp';</script>");
		}
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
