package com.hnsic.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hnsic.dao.SysadminDao;
import com.hnsic.daoimpl.SysadminDaoimpl;
import com.hnsic.entity.Student;

public class Sysadmin_querystudent extends HttpServlet {
	//��ѯ����ѧ����Ϣ
	
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try{
			//�½���������
			SysadminDao sysadminDao=new SysadminDaoimpl();
			//���ò�ѯ����
			List<Student> list=sysadminDao.querystudent();
			
			System.out.println(list);
			
			//���������Ự��
			HttpSession session=request.getSession();
			session.setAttribute("lista", list);
			response.sendRedirect("/dormitory/Sysadmin/sysadmin_studentmessage.jsp");
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
