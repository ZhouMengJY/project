package com.hnsic.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.hnsic.dao.AdminDao;
import com.hnsic.dao.InstructorDao;
import com.hnsic.dao.RepairerDao;
import com.hnsic.dao.StudentDao;
import com.hnsic.daoimpl.AdminDaoimpl;
import com.hnsic.daoimpl.InstructorDaoimpl;
import com.hnsic.daoimpl.RepairerDaoimpl;
import com.hnsic.daoimpl.StudentDaoimpl;
import com.hnsic.entity.Admin;
import com.hnsic.entity.Instructor;
import com.hnsic.entity.Repairer;
import com.hnsic.entity.Student;



public class login extends HttpServlet {
	//登录
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			//接受表单提交过来的数据
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			String UserName=request.getParameter("UserName");
			String password=request.getParameter("password");
			
			//获取要登录的身份
			String type=request.getParameter("type");
			String type1="学生";
			String type2="辅导员";
			String type3="宿舍管理员";
		//	String type4="后勤";
			
			
			//使用ALTER弹出提示信息，防止乱码。
			String CONTENT_TYPE = "text/html; charset=GBK";
			response.setContentType(CONTENT_TYPE);			
			PrintWriter out=response.getWriter();     //初始化out对象
			
			if(type.equals(type1)){				//学生登录
					//把数据装载到Javabean
					Student student=new Student();
					student.setStuID(UserName);
					student.setPassword(password);	
					
					//调用数据Dao层
					StudentDao studentDao=new StudentDaoimpl();	
					
					System.out.println(UserName);
					System.out.println(password);
		
					boolean flag=studentDao.Login(student);
					
					//应用 session保存bean信息		
					HttpSession session=request.getSession();
					session.setAttribute("student",student);
					
					//登录成功则转发到系统页面，错误则提示错误信息。
					if(flag){
					//response.sendRedirect("/dormitory/student/loginsuccess.jsp");
						response.sendRedirect("/dormitory/StudentMainPage.html");
						
						}else{					
							if(student.getRemarks().equals("1")){
								out.print("<script language='javascript'>alert('密码错误!!');window.location.href='/dormitory/LoginPage.html';</script>");   
							}
							else{
								out.print("<script language='javascript'>alert('用户名不存在!!');window.location.href='/dormitory/LoginPage.html';</script>");            
							}						
					}					
			}
			else if(type.equals(type2)){             //辅导员登录
				//把数据装载到Javabean				
				Instructor instructor=new Instructor();
				instructor.setInstructorID(UserName);
				instructor.setPassword(password);
				
				//调用数据Dao层
				InstructorDao instructorDao=new InstructorDaoimpl();
				
				System.out.println(UserName);
				System.out.println(password);
				
				//调用instructorDao的Login()方法
				boolean flag=instructorDao.Login(instructor);
				
				//应用 session保存bean信息		
				HttpSession session=request.getSession();
				session.setAttribute("instructor",instructor);
				
				//登录成功则转发到系统页面，错误则提示错误信息。
				if(flag){
					//response.sendRedirect("/dormitory/instructor/loginsuccess.jsp");
					response.sendRedirect("/dormitory/InstructorMainPage.html");
					}else{					
						if(instructor.getRemarks().equals("1")){
							out.print("<script language='javascript'>alert('密码错误!!');window.location.href='/dormitory/LoginPage.html';</script>");   
						}
						else{
							out.print("<script language='javascript'>alert('用户名不存在!!');window.location.href='/dormitory/LoginPage.html';</script>");            
						}						
				}					
				
				
				}else if(type.equals(type3)){              //宿舍管理员登录
					//把数据装载到Javabean
					Admin admin=new Admin();
					admin.setAdminID(UserName);
					admin.setPassword(password);
					
					AdminDao adminDao=new AdminDaoimpl();
					
					System.out.println(UserName);
					System.out.println(password);
					
					boolean flag=adminDao.Login(admin);
					
					//应用 session保存bean信息		
					HttpSession session=request.getSession();
					session.setAttribute("admin",admin);
					
					//登录成功则转发到系统页面，错误则提示错误信息。
					if(flag){
						response.sendRedirect("/dormitory/AdminMainPage.html");
						}else{					
							if(admin.getRemarks().equals("1")){
								out.print("<script language='javascript'>alert('密码错误!!');window.location.href='/dormitory/LoginPage.html';</script>");   
							}
							else{
								out.print("<script language='javascript'>alert('用户名不存在!!');window.location.href='/dormitory/LoginPage.html';</script>");            
							}			
						}	
					
				}else{              						//后勤人员登录
					//把数据装载到Javabean
					Repairer repairer=new Repairer();
					repairer.setRepairerID(UserName);
					repairer.setPassword(password);
					
					RepairerDao repairerDao=new RepairerDaoimpl();
					
					System.out.println(UserName);
					System.out.println(password);
					
					boolean flag=repairerDao.Login(repairer);
					
					//应用 session保存bean信息		
					HttpSession session=request.getSession();
					session.setAttribute("repairer",repairer);
					
					//登录成功则转发到系统页面，错误则提示错误信息。
					if(flag){
						response.sendRedirect("/dormitory/RepairerMainPage.html");
						}else{					
							if(repairer.getRemarks().equals("1")){
								out.print("<script language='javascript'>alert('密码错误!!');window.location.href='/dormitory/LoginPage.html';</script>");   
							}
							else{
								out.print("<script language='javascript'>alert('用户名不存在!!');window.location.href='/dormitory/LoginPage.html';</script>");            
							}				
						}	
					
					
				}
//			else{              						//系统管理员登录
//					//把数据装载到Javabean
//					Sysadmin sysadmin=new Sysadmin();
//					sysadmin.setSysadminID(UserName);
//					sysadmin.setPassword(password);
//										
//					SysadminDao sysadminDao=new SysadminDaoimpl();
//					
//					System.out.println(UserName);
//					System.out.println(password);
//					
//					boolean flag=sysadminDao.Login(sysadmin);
//					
//					//应用 session保存bean信息		
//					HttpSession session=request.getSession();
//					session.setAttribute("sysadmin",sysadmin);
//					
//					//登录成功则转发到系统页面，错误则提示错误信息。
//					if(flag){
//						response.sendRedirect("/dormitory/SysadminMainPage.html");  
//						}else{					
//							if(sysadmin.getRemarks().equals("1")){
//								out.print("<script language='javascript'>alert('密码错误!!');window.location.href='/dormitory/LoginPage.html';</script>");   
//							}
//							else{
//								out.print("<script language='javascript'>alert('用户名不存在!!');window.location.href='/dormitory/LoginPage.html';</script>");            
//							}				
//						}
//				}
		}	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
