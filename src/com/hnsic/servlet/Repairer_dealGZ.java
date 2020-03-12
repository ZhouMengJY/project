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
	//维修人员处理故障

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
		//获取表单提交过来的要处理的故障信息编号
		String repairID=request.getParameter("repair.repairID");
		//新建操作对象
		Repair repair=new Repair();
		repair.setRepairID(repairID);
		//调用Dao层
		try{
			RepairerDao repairerDao=new RepairerDaoimpl();	
			boolean flag=repairerDao.dealGz(repair);
//			System.out.println(flag);
			if(flag){
				out.print("<script language='javascript'>alert('处理故障信息成功!!!');" +
						"window.location.href='/dormitory/repairer/Repairer_dealsuccess.jsp';</script>");
			}else{
				out.print("<script language='javascript'>alert('发生未知错误，处理故障信息失败!!!');" +
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
