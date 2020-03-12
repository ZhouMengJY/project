package com.hnsic.dao;

import java.util.List;


import com.hnsic.entity.Grade;
import com.hnsic.entity.Repair;
import com.hnsic.entity.Student;



public interface StudentDao {
	public boolean Login(Student student);    		//学生登录
	public List<Student> getstudent(String stuID);  //查看学生信息
	public List<Grade> getgrade(String dormID,String roomID);		//查看寝室扣分情况
	public boolean change(Student student);			//修改密码
	public List<Repair> getAllRepair();				//查询所有故障維修信息
	public boolean add(Repair repair);				//故障申报
}
