package com.hnsic.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hnsic.dao.AdminDao;
import com.hnsic.entity.Absent;
import com.hnsic.entity.Admin;
import com.hnsic.entity.Grade;
import com.hnsic.until.Datebase;

public class AdminDaoimpl implements AdminDao{

	public boolean Login(Admin admin) {   //宿舍管理员登录
		boolean flag=false;
		Connection conn=null;
		PreparedStatement prst=null;
		ResultSet rs=null;
		String sql="select * from Admin where adminID=?";
		Datebase datebase=new Datebase();
		try{
			conn=datebase.getConn();
			prst=conn.prepareStatement(sql);
			prst.setString(1, admin.getAdminID());
			rs=prst.executeQuery();	
			if(rs.next()){
				String realpassword=rs.getString(3);
				
				if(admin.getPassword().equals(realpassword.trim())){
					//登陆成功
					flag=true;
					}else{					
					  //密码错误
						admin.setRemarks("1");				
						}
				}
			else{
				admin.setRemarks("2");//用户名不存在，请重新输入。					
				}	
			
		}catch(SQLException e){
			e.printStackTrace();
		}		
		return flag;	
	}

	
	
	public boolean record(Grade grade) {  //记录学生寝室扣分情况
		boolean flag=false;
		Connection conn=null;
		PreparedStatement prst=null;
		String sql="insert into Grade values(?,?,?,?,?,?,?)";
		//连接数据库
		System.out.println("----------");
		Datebase datebase=new Datebase();
		//将数据插入数据库
		try{		
			conn=datebase.getConn();
			prst=conn.prepareStatement(sql);
			prst.setString(1,grade.getDateID());
			prst.setString(2,grade.getTime());
			prst.setString(3,grade.getDormID());
			prst.setString(4,grade.getRoomID());
			prst.setString(5,grade.getPoints());
			prst.setString(6,grade.getScore());
			prst.setString(7,grade.getRemarks());
			
			int n=prst.executeUpdate();
			if(n>0)
				flag=true;
		}catch(SQLException e){
			e.printStackTrace();
			return flag;
		}	
		return flag;
	}



	public List<Grade> getgrade(String dormID,String roomID) {	//查询学生寝室扣分情况
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



	public boolean absent(Absent absent) {			//记录学生缺寝情况
		boolean flag=false;
		Connection conn=null;
		PreparedStatement prst=null;
		String sql="insert into Absent values(?,?,?,?,?,?,?,?)";
		//连接数据库
		System.out.println("----------");
		Datebase datebase=new Datebase();
		//将数据插入数据库
		try{		
			conn=datebase.getConn();
			prst=conn.prepareStatement(sql);
			//prst.setString(1,grade.getDateID());
			prst.setString(1,absent.getAbsentID());
			prst.setString(2,absent.getStuID());
			prst.setString(3,absent.getName());
			prst.setString(4,absent.getDormID());
			prst.setString(5,absent.getRoomID());
			prst.setString(6,absent.getTime());
			prst.setString(7,absent.getPhone());
			prst.setString(8,absent.getRemarks());
			
			int n=prst.executeUpdate();
			if(n>0)
				flag=true;
		}catch(SQLException e){
			e.printStackTrace();
			return flag;
		}	
		return flag;
	}

	
	public List<Absent> getAbsent() {				//查询学生缺寝情况
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


		
	public List<Admin> getAdmin(String adminID) {	//查询宿舍管理员个人信息
		Connection conn=null;
		PreparedStatement prst=null;
		ResultSet rs=null;
		
		List<Admin> list=new ArrayList<Admin>();
		String sql="select * from Admin where adminID=?";
		Datebase datebase=new Datebase();
		try{
			conn=datebase.getConn();
			prst=conn.prepareStatement(sql);
			prst.setString(1,adminID);
			rs=prst.executeQuery();//执行查询
			while(rs.next()){//遍历结果集
				//建立bean对象
				Admin admin=new Admin();
				//将数据装载进Bean对象				
				admin.setAdminID(rs.getString(1));
				admin.setDormID(rs.getString(2));
				admin.setPassword(rs.getString(3));
				admin.setName(rs.getString(4));
				admin.setSex(rs.getString(5));
				admin.setPhone(rs.getString(6));
				admin.setRemarks(rs.getString(7));				
				
				list.add(admin);										
			}			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return list;
	}



	public boolean change(Admin admin) {			//修改密码
		boolean flag=false;
		Connection conn=null;
		PreparedStatement prst=null;
		String sql="update Admin set password=? where adminID=?";
	//连接数据库
		Datebase datebase=new Datebase();
	//将数据插入数据库
		try{		
			conn=datebase.getConn();
			prst=conn.prepareStatement(sql);
			System.out.println(admin.getAdminID()+admin.getPassword());
			
			prst.setString(1,admin.getPassword());
			prst.setString(2,admin.getAdminID());
			
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



	public List<Grade> getAllgrade() {				//查询所有学生寝室扣分情况
		Connection conn=null;
		PreparedStatement prst=null;
		ResultSet rs=null;
		
		List<Grade> list=new ArrayList<Grade>();
		String sql="select * from Grade";
		//获取数据库连接
		Datebase datebase=new Datebase();
		try{
			conn=datebase.getConn();
			prst=conn.prepareStatement(sql);
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

}
