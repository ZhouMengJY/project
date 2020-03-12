package com.hnsic.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hnsic.dao.InstructorDao;
import com.hnsic.entity.Absent;
import com.hnsic.entity.Grade;
import com.hnsic.entity.Instructor;
import com.hnsic.entity.Student;
import com.hnsic.until.Datebase;

public class InstructorDaoimpl implements InstructorDao{

	public boolean Login(Instructor instructor) {		//辅导员登录
		boolean flag=false;
		Connection conn=null;
		PreparedStatement prst=null;
		ResultSet rs=null;
		String sql="select * from Instructor where instructorID=?";
		Datebase datebase=new Datebase();
		try{
			conn=datebase.getConn();
			prst=conn.prepareStatement(sql);
			prst.setString(1, instructor.getInstructorID());
			rs=prst.executeQuery();	
			if(rs.next()){
				String realpassword=rs.getString(2);
				
				if(instructor.getPassword().equals(realpassword.trim())){
					//登陆成功
					flag=true;
					}else{					
					  //密码错误
						instructor.setRemarks("1");				
						}
				}
			else{
				instructor.setRemarks("2");//用户名不存在，请重新输入。					
				}	
			
		}catch(SQLException e){
			e.printStackTrace();
		}		
		return flag;	
	}
	
	public List<Student> getstudent(String stuID) {		//查询学生信息
		Connection conn=null;
		PreparedStatement prst=null;
		ResultSet rs=null;
		
		List<Student> list=new ArrayList<Student>();
		String sql="select * from Student where stuID=?";
		Datebase datebase=new Datebase();
		try{
			conn=datebase.getConn();
			prst=conn.prepareStatement(sql);
			prst.setString(1,stuID);
			rs=prst.executeQuery();//执行查询
			while(rs.next()){//遍历结果集
				//建立bean对象
				Student student=new Student();
				//将数据装载进Bean对象
				student.setStuID(rs.getString(1));
				student.setPassword(rs.getString(2));
				student.setName(rs.getString(3));
				student.setSex(rs.getString(4));
				student.setDormID(rs.getString(5));
				student.setRoomID(rs.getString(6));
				student.setXueyuan(rs.getString(7));
				student.setMajor(rs.getString(8));
				student.setClasses(rs.getString(9));
				student.setPhone(rs.getString(10));
				student.setBirthday(rs.getString(11));
				student.setRemarks(rs.getString(12));
				list.add(student);
										
			}			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Instructor> getinstructor(String instructorID) {	//查询辅导员信息
		Connection conn=null;
		PreparedStatement prst=null;
		ResultSet rs=null;
		
		List<Instructor> list=new ArrayList<Instructor>();
		String sql="select * from Instructor where instructorID=?";
		Datebase datebase=new Datebase();
		try{
			conn=datebase.getConn();
			prst=conn.prepareStatement(sql);
			prst.setString(1,instructorID);
			rs=prst.executeQuery();//执行查询
			while(rs.next()){//遍历结果集
				//建立bean对象
				Instructor instructor=new Instructor();
				
				//将数据装载进Bean对象	
				instructor.setInstructorID(rs.getString(1));
				instructor.setPassword(rs.getString(2));
				instructor.setName(rs.getString(3));
				instructor.setSex(rs.getString(4));
				instructor.setPhone(rs.getString(5));
				instructor.setRemarks(rs.getString(6));				
				list.add(instructor);										
			}			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return list;
	}

	public boolean change(Instructor instructor) {		//修改密码
		boolean flag=false;
		Connection conn=null;
		PreparedStatement prst=null;
		String sql="update Instructor set password=? where instructorID=?";
		//连接数据库
		Datebase datebase=new Datebase();
		//将数据插入数据库
		try{		
			conn=datebase.getConn();
			prst=conn.prepareStatement(sql);
			System.out.println(instructor.getInstructorID()+instructor.getPassword());
			
			prst.setString(1,instructor.getPassword());
			prst.setString(2,instructor.getInstructorID());
			int n=prst.executeUpdate();
			System.out.println(n);
			if(n>0)
				flag=true;
		}catch(SQLException e){
			e.printStackTrace();
			return flag;
		}	
		return flag;		
	}

	public List<Absent> getAbsent() {		//查询学生缺寝情况
		Connection conn=null;
		PreparedStatement prst=null;
		ResultSet rs=null;
		
		List<Absent> list=new ArrayList<Absent>();
		String sql="select * from Absent";
		//获取数据库连接
		Datebase datebase=new Datebase();
		try{
			conn=datebase.getConn();
			prst=conn.prepareStatement(sql);
			rs=prst.executeQuery();//执行查询
			while(rs.next()){//遍历结果集
				//建立bean对象
				Absent absent=new Absent();
				
				//将数据装载进Bean对象
				absent.setAbsentID(rs.getString(1));
				absent.setStuID(rs.getString(2));
				absent.setName(rs.getString(3));
				absent.setDormID(rs.getString(4));
				absent.setRoomID(rs.getString(5));
				absent.setTime(rs.getString(6));
				absent.setPhone(rs.getString(7));
				absent.setRemarks(rs.getString(8));
		
				list.add(absent);								
			}			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return list;
	}

	public List<Grade> getgrade(String dormID, String roomID) {	//查看寝室扣分情况
		Connection conn=null;
		PreparedStatement prst=null;
		ResultSet rs=null;
		
		List<Grade> list=new ArrayList<Grade>();
		String sql="select * from Grade where dormID=? and roomID=?";
		Datebase datebase=new Datebase();
		try{
			conn=datebase.getConn();
			prst=conn.prepareStatement(sql);
			prst.setString(1,dormID);
			prst.setString(2,roomID);
			rs=prst.executeQuery();//执行查询
			while(rs.next()){//遍历结果集
				//建立bean对象		
				Grade grade=new Grade();
				
				//将数据装载进Bean对象
				grade.setDateID(rs.getString(1));
				grade.setTime(rs.getString(2));
				grade.setDormID(rs.getString(3));
				grade.setRoomID(rs.getString(4));
				grade.setPoints(rs.getString(5));
				grade.setScore(rs.getString(6));
				grade.setRemarks(rs.getString(7));
						
				list.add(grade);										
			}			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return list;
	}

	public List<Student> getallstudent(String classes) {	//查询所有班级相同的学生信息
		Connection conn=null;
		PreparedStatement prst=null;
		ResultSet rs=null;
		
		List<Student> list=new ArrayList<Student>();
		String sql="select * from Student where classes=?";
		Datebase datebase=new Datebase();
		try{
			conn=datebase.getConn();
			prst=conn.prepareStatement(sql);
			prst.setString(1,classes);
			rs=prst.executeQuery();//执行查询
			while(rs.next()){//遍历结果集
				//建立bean对象
				Student student=new Student();
				//将数据装载进Bean对象
				student.setStuID(rs.getString(1));
				student.setPassword(rs.getString(2));
				student.setName(rs.getString(3));
				student.setSex(rs.getString(4));
				student.setDormID(rs.getString(5));
				student.setRoomID(rs.getString(6));
				student.setXueyuan(rs.getString(7));
				student.setMajor(rs.getString(8));
				student.setClasses(rs.getString(9));
				student.setPhone(rs.getString(10));
				student.setBirthday(rs.getString(11));
				student.setRemarks(rs.getString(12));
				
				System.out.println(rs.getString(9));
				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));
				
				list.add(student);
										
			}			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return list;
	}	
	
	
	
}	