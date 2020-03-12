package com.hnsic.dao;

import java.util.List;

import com.hnsic.entity.Absent;
import com.hnsic.entity.Grade;
import com.hnsic.entity.Instructor;
import com.hnsic.entity.Student;

public interface InstructorDao {
	public boolean Login(Instructor instructor);				//辅导员登录
	public List<Student> getstudent(String stuID);				//查看单个学生信息
	public List<Student> getallstudent(String classes);			//查看班级相同的学生信息
	public List<Instructor> getinstructor(String instructorID);	//查看辅导员个人信息信息
	public boolean change(Instructor instructor);				//修改密码
	public List<Absent> getAbsent();							//查询学生缺寝情况
	public List<Grade> getgrade(String dormID,String roomID);	//查看寝室扣分情况
	
}
