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

public class Sysadmin_deleteadmin extends HttpServlet {
	//ɾ���������Ա��Ϣ
		
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
		//��ȡ���ύ������Ҫɾ������Ʒ���
		String adminID=request.getParameter("admin.adminID");
		//�½���������
		Admin admin=new Admin();
		admin.setAdminID(adminID);
		
		//����Dao��
		try{
			SysadminDao sysadminDao=new SysadminDaoimpl();
			boolean flag=sysadminDao.deleteinadmin(admin);
			
			if(flag){
				out.print("<script language='javascript'>alert('ɾ���������Ա��Ϣ�ɹ�!!!');" +
						"window.location.href='/dormitory/Sysadmin/sysadmin_deletesuccess.jsp';</script>");
			}else{
				out.print("<script language='javascript'>alert('����δ֪����ɾ���������Ա��Ϣʧ��!!!');" +
						"window.location.href='/dormitory/Sysadmin/sysadmin_deletefail.jsp';</script>");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
