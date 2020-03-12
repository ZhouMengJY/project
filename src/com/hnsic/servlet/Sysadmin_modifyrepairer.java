package com.hnsic.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hnsic.dao.SysadminDao;
import com.hnsic.daoimpl.SysadminDaoimpl;
import com.hnsic.entity.Repairer;

public class Sysadmin_modifyrepairer extends HttpServlet {
	//�޸�ά����Ա��Ϣ

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
		String repairerID=request.getParameter("repairerID");
		String password=request.getParameter("password");
		String name=request.getParameter("name");
		String sex=request.getParameter("sex");
		String phone=request.getParameter("phone");
		String remarks=request.getParameter("remarks");
				
		System.out.println(repairerID);
			
		//������װ�ص�JavaBean
		Repairer repairer=new Repairer();
		repairer.setRepairerID(repairerID);
		repairer.setPassword(password);
		repairer.setName(name);
		repairer.setSex(sex);
		repairer.setPhone(phone);
		repairer.setRemarks(remarks);
		//��������Dao��
		SysadminDao sysadminDao=new SysadminDaoimpl();
		boolean flag=sysadminDao.modifyrepairer(repairer);
			
		if(flag){
			out.print("<script language='javascript'>alert('�޸��������Ա��Ϣ�ɹ�!!!');" +
							"window.location.href='/dormitory/Sysadmin/sysadmin_modifysuccess.jsp';</script>");
		  }else{
			out.print("<script language='javascript'>alert('�޸��������Ա��Ϣʧ�ܣ��������޸�!!!');" +
							"window.location.href='/dormitory/Sysadmin/sysadmin_modifyfail.jsp';</script>");
				}
		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
