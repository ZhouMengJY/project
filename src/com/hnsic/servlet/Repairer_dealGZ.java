package com.hnsic.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hnsic.dao.RepairerDao;
import com.hnsic.daoimpl.RepairerDaoimpl;
import com.hnsic.entity.Repair;

public class Repairer_dealGZ extends HttpServlet {
	//ά����Ա�������

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
		//��ȡ���ύ������Ҫ����Ĺ�����Ϣ���
		String repairID=request.getParameter("repair.repairID");
		//�½���������
		Repair repair=new Repair();
		repair.setRepairID(repairID);
		//����Dao��
		try{
			RepairerDao repairerDao=new RepairerDaoimpl();	
			boolean flag=repairerDao.dealGz(repair);
//			System.out.println(flag);
			if(flag){
				out.print("<script language='javascript'>alert('���������Ϣ�ɹ�!!!');" +
						"window.location.href='/dormitory/repairer/Repairer_dealsuccess.jsp';</script>");
			}else{
				out.print("<script language='javascript'>alert('����δ֪���󣬴��������Ϣʧ��!!!');" +
						"window.location.href='/dormitory/repairer/Repairer_dealfail.jsp';</script>");
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
