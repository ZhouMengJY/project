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

public class Sysadmin_modifystudent extends HttpServlet {
	//�޸�ѧ����Ϣ
	
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
		//����JavaBean����
		Student student=new Student();
		//������װ�ص�JavaBean
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
		//��������Dao��
		SysadminDao sysadminDao=new SysadminDaoimpl();
		boolean flag=sysadminDao.modifystudent(student);
		if(flag){
			out.print("<script language='javascript'>alert('�޸�ѧ���ɹ�!!!');" +
					"window.location.href='/dormitory/Sysadmin/sysadmin_modifysuccess.jsp';</script>");
		}else{
			out.print("<script language='javascript'>alert('�޸�ѧ��ʧ�ܣ��������޸�!!!');" +
					"window.location.href='/dormitory/Sysadmin/sysadmin_modifyfail.jsp';</script>");
		}
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
