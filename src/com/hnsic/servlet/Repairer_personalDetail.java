package com.hnsic.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hnsic.dao.RepairerDao;
import com.hnsic.daoimpl.RepairerDaoimpl;
import com.hnsic.entity.Repairer;

public class Repairer_personalDetail extends HttpServlet {
	//后勤维修人员查看个人信息
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");	
		
		//获取存放在session中的repairerID
		Repairer repairer=(Repairer)session.getAttribute("repairer");
		String repairerID=repairer.getRepairerID();
		
		System.out.println(repairer);
		try{			
			//新建操作对象
			RepairerDao repairerDao=new RepairerDaoimpl();
			//调用查询方法
			List<Repairer> list=repairerDao.getRepairer(repairerID);
			//把数组放入会话中
			request.setAttribute("list12", list);
			request.getRequestDispatcher("repairer/repairer_personalDetail.jsp").forward(request, response);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
