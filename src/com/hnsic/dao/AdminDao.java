package com.hnsic.dao;

import java.util.List;

import com.hnsic.entity.Absent;
import com.hnsic.entity.Admin;
import com.hnsic.entity.Grade;

public interface AdminDao {
	public boolean Login(Admin admin);				//宿舍管理员登录
	public boolean record(Grade grade);				//记录学生寝室扣分情况
	public List<Grade> getgrade(String dormID,String roomID);	//查询学生寝室扣分情况
	public List<Grade> getAllgrade();				//查询所有学生寝室扣分情况
	public boolean absent(Absent absent);			//记录学生缺寝情况
	public List<Absent> getAbsent();				//查询学生缺寝情况
	public List<Admin> getAdmin(String adminID);	//查询个人信息
	public boolean change(Admin admin);				//修改密码
}
