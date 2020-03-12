package com.hnsic.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hnsic.dao.StudentDao;
import com.hnsic.entity.Grade;
import com.hnsic.entity.Repair;
import com.hnsic.entity.Student;
import com.hnsic.until.Datebase;

public class StudentDaoimpl implements StudentDao{
	public boolean Login(Student student) {  			//学生登录
		boolean flag=false;
		Connection conn=null;
		PreparedStatement prst=null;
		ResultSet rs=null;
		String sql="select * from Student where stuID=?";
		Datebase datebase=new Datebase();
		try{
			conn=datebase.getConn();
			prst=conn.prepareStatement(sql);
			prst.setString(1, student.getStuID());
			rs=prst.executeQuery();	
			if(rs.next()){
				student.setStuID(rs.getString(1));
				String realpassword=rs.getString(2);
				
				if(student.getPassword().equals(realpassword.trim())){
					//登陆成功
					flag=true;
					}else{					
					//密码错误
					student.setRemarks("1");				
						}
				}
			else{
				//用户名不存在，请重新输入。
				student.setRemarks("2");					
				}	
			
		}catch(SQLException e){
			e.printStackTrace();
		}		
		return flag;
	}

	public List<Student> getstudent(String stuID){      //查询学生个人信息
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

	public boolean change(Student student) {			//修改密码		
		boolean flag=false;
		Connection conn=null;
		PreparedStatement prst=null;
		String sql="update Student set password=? where stuID=?";
	//连接数据库
		Datebase datebase=new Datebase();
	//将数据插入数据库
		try{		
			conn=datebase.getConn();
			prst=conn.prepareStatement(sql);
			System.out.println(student.getStuID()+student.getPassword());
			
			prst.setString(1,student.getPassword());
			prst.setString(2,student.getStuID());
			
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

	public List<Grade> getgrade(String dormID,String roomID) {		//查询寝室得分
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

	public List<Repair> getAllRepair() {				//查询所有故障維修信息
		Connection conn=null;
		PreparedStatement prst=null;
		ResultSet rs=null;
		List<Repair> list=new ArrayList<Repair>();
		String sql="select * from Repair";
		//获取数据库连接
		Datebase datebase=new Datebase();
		try{
			conn=datebase.getConn();
			prst=conn.prepareStatement(sql);
			rs=prst.executeQuery();//执行查询
			while(rs.next()){//遍历结果集
				
				//建立bean对象
				Repair repair=new Repair();
				
				//将数据装载进Bean对象
				repair.setRepairID(rs.getString(1));
				repair.setName(rs.getString(2));
				repair.setPhone(rs.getString(3));
				repair.setTimes(rs.getString(4));
				repair.setDormID(rs.getString(5));
				repair.setRoomID(rs.getString(6));
				repair.setGZmiaoshu(rs.getString(7));
				repair.setRemarks(rs.getString(8));			
				list.add(repair);								
			}			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return list;
	}

	public boolean add(Repair repair) {					//故障申报
		boolean flag=false;
		Connection conn=null;
		PreparedStatement prst=null;
		String sql="insert into Repair values(?,?,?,?,?,?,?,?)";
		//连接数据库
		System.out.println("----------");
		Datebase datebase=new Datebase();
		//将数据插入数据库
		try{		
			conn=datebase.getConn();
			prst=conn.prepareStatement(sql);
			prst.setString(1,repair.getRepairID());
			prst.setString(2,repair.getName());
			prst.setString(3,repair.getPhone());
			prst.setString(4,repair.getTimes());
			prst.setString(5,repair.getDormID());
			prst.setString(6,repair.getRoomID());
			prst.setString(7,repair.getGZmiaoshu());
			prst.setString(8,repair.getRemarks());
			int n=prst.executeUpdate();
			if(n>0)
				flag=true;
		}catch(SQLException e){
			e.printStackTrace();
			return flag;
		}	
		return flag;
	}
}
