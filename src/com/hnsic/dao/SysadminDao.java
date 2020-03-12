package com.hnsic.dao;

import java.util.List;

import com.hnsic.entity.Admin;
import com.hnsic.entity.Instructor;
import com.hnsic.entity.Repairer;
import com.hnsic.entity.Student;
import com.hnsic.entity.Sysadmin;

public interface SysadminDao {		//系统管理员
	public boolean Login(Sysadmin sysadmin);				//系统管理员登录
	public boolean addstudent(Student student);				//添加学生
	public boolean addinstructor(Instructor instructor);	//添加辅导员
	public boolean addadmin(Admin admin);					//添加宿舍管理员
	public boolean addrepairer(Repairer repairer);			//添加维修人员信息
	public List<Instructor> queryinstructor();				//查询辅导员
	public List<Admin> queryadmin();						//查询宿舍管理员
	public List<Repairer> queryrepairer();					//查询宿舍管理员
	public List<Student> querystudent();					//查询学生
	public boolean modifyinstructor(Instructor instructor);	//修改辅导员信息
	public boolean modifyadmin(Admin admin);				//修改宿舍管理员信息
	public boolean modifystudent(Student student);			//修改学生信息
	public boolean modifyrepairer(Repairer repairer);		//修改维修人员信息
	public boolean modifypassword(Sysadmin sysadmin);		//修改密码	
	public boolean deleteinstructor(Instructor instructor);	//删除辅导员信息
	public boolean deleteinadmin(Admin admin);				//删除宿舍管理员信息
	public boolean deleterepairer(Repairer repairer);		//删除后勤维修人员信息
	
}
