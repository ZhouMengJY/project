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
import com.hnsic.entity.Instructor;

public class Sysadmin_queryinstructor extends HttpServlet {
	//��ѯ����Ա��Ϣ
	
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try{
			//�½���������
			SysadminDao sysadminDao=new SysadminDaoimpl();
			//���ò�ѯ����
			List<Instructor> list=sysadminDao.queryinstructor();
			
			System.out.println(list);
			
			//���������Ự��
			HttpSession session=request.getSession();
			session.setAttribute("listb", list);
			response.sendRedirect("/dormitory/Sysadmin/sysadmin_instructormessage.jsp");
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
