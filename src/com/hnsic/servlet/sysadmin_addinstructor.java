package com.hnsic.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hnsic.dao.SysadminDao;
import com.hnsic.daoimpl.SysadminDaoimpl;
import com.hnsic.entity.Instructor;

public class sysadmin_addinstructor extends HttpServlet {
	//��Ӹ���Ա
	
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//���ñ��뷽ʽ
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//ʹ��ALTER������ʾ��Ϣ����ֹ���롣
		String CONTENT_TYPE = "text/html; charset=GBK";
		response.setContentType(CONTENT_TYPE);			
		PrintWriter out=response.getWriter();     //��ʼ��out����
		//���ܱ��ύ����������
		String instructorID=request.getParameter("instructorID");
		String password=request.getParameter("password");
		String name=request.getParameter("name");
		String sex=request.getParameter("sex");
		String phone=request.getParameter("phone");
		String remarks=request.getParameter("remarks");
		//������װ�ص�JavaBean
		Instructor instructor=new Instructor();
		instructor.setInstructorID(instructorID);
		instructor.setPassword(password);
		instructor.setName(name);
		instructor.setSex(sex);
		instructor.setPhone(phone);
		instructor.setRemarks(remarks);
		//��������Dao��
		SysadminDao sysadminDao=new SysadminDaoimpl();
		boolean flag=sysadminDao.addinstructor(instructor);
		if(flag){
			out.print("<script language='javascript'>alert('��Ӹ���Ա�ɹ�!!!');" +
					"window.location.href='/dormitory/Sysadmin/sysadmin_addinstructor.jsp';</script>");
		}else{
			out.print("<script language='javascript'>alert('��Ӹ���Աʧ�ܣ����������.');" +
					"window.location.href='/dormitory/Sysadmin/sysadmin_addinstructor.jsp';</script>");
		}				
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
