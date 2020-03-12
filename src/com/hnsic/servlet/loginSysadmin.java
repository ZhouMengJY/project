package com.hnsic.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hnsic.dao.SysadminDao;
import com.hnsic.daoimpl.SysadminDaoimpl;
import com.hnsic.entity.Sysadmin;

public class loginSysadmin extends HttpServlet {
	//ϵͳ����Ա��¼
	
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//���ܱ��ύ����������
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String UserName=request.getParameter("username");
		String password=request.getParameter("password");
		//ʹ��ALTER������ʾ��Ϣ����ֹ���롣
		String CONTENT_TYPE = "text/html; charset=GBK";
		response.setContentType(CONTENT_TYPE);			
		PrintWriter out=response.getWriter();     //��ʼ��out����
		
		//������װ�ص�Javabean
		Sysadmin sysadmin=new Sysadmin();
		sysadmin.setSysadminID(UserName);
		sysadmin.setPassword(password);
							
		SysadminDao sysadminDao=new SysadminDaoimpl();
		
		System.out.println(UserName);
		System.out.println(password);
		
		boolean flag=sysadminDao.Login(sysadmin);
		
		//Ӧ�� session����bean��Ϣ		
		HttpSession session=request.getSession();
		session.setAttribute("sysadmin",sysadmin);
		
		//��¼�ɹ���ת����ϵͳҳ�棬��������ʾ������Ϣ��
		if(flag){
			response.sendRedirect("/dormitory/SysadminMainPage.html");  
			}else{					
				if(sysadmin.getRemarks().equals("1")){
					out.print("<script language='javascript'>alert('�������!!');window.location.href='/dormitory/SysadminLoginPage.html';</script>");   
				}
				else{
					out.print("<script language='javascript'>alert('�û���������!!');window.location.href='/dormitory/SysadminLoginPage.html';</script>");            
				}				
			}
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
