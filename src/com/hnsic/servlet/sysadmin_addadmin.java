package com.hnsic.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hnsic.dao.SysadminDao;
import com.hnsic.daoimpl.SysadminDaoimpl;
import com.hnsic.entity.Admin;

public class sysadmin_addadmin extends HttpServlet {
	//����������Ա����Ա
	
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
		String adminID=request.getParameter("adminID");
		String dormID=request.getParameter("dormID");
		String password=request.getParameter("password");
		String name=request.getParameter("name");
		String sex=request.getParameter("sex");
		String phone=request.getParameter("phone");
		String remarks=request.getParameter("remarks");
		//������װ�ص�JavaBean
		Admin admin=new Admin();
		admin.setAdminID(adminID);
		admin.setDormID(dormID);
		admin.setPassword(password);
		admin.setName(name);
		admin.setSex(sex);
		admin.setPhone(phone);
		admin.setRemarks(remarks);
		//��������Dao��
		SysadminDao sysadminDao=new SysadminDaoimpl();
		boolean flag=sysadminDao.addadmin(admin);
		if(flag){
			out.print("<script language='javascript'>alert('��Ӹ���Ա�ɹ�!!!');" +
							"window.location.href='/dormitory/Sysadmin/sysadmin_addadmin.jsp';</script>");
			}else{
			out.print("<script language='javascript'>alert('��Ӹ���Աʧ�ܣ����������.');" +
							"window.location.href='/dormitory/Sysadmin/sysadmin_addadmin.jsp';</script>");
			}			
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
