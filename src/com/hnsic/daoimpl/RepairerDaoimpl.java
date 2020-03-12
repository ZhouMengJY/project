package com.hnsic.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hnsic.dao.RepairerDao;
import com.hnsic.entity.Repair;
import com.hnsic.entity.Repairer;
import com.hnsic.until.Datebase;

public class RepairerDaoimpl implements RepairerDao{

	public boolean Login(Repairer repairer) {        //后勤维修人员登录
		boolean flag=false;
		Connection conn=null;
		PreparedStatement prst=null;
		ResultSet rs=null;
		String sql="select * from Repairer where repairerID=?";
		Datebase datebase=new Datebase();
		try{
			conn=datebase.getConn();
			prst=conn.prepareStatement(sql);
			prst.setString(1, repairer.getRepairerID());
			rs=prst.executeQuery();	
			if(rs.next()){
				String realpassword=rs.getString(2);
				
				if(repairer.getPassword().equals(realpassword.trim())){
					//登陆成功
					flag=true;
					}else{					
					  //密码错误
						repairer.setRemarks("1");				
						}
				}
			else{
				repairer.setRemarks("2");//用户名不存在，请重新输入。					
				}	
			
		}catch(SQLException e){
			e.printStackTrace();
		}		
		return flag;	
	}

	
	public List<Repairer> getRepairer(String repairerID) {	//后勤维修人员查询个人信息
		Connection conn=null;
		PreparedStatement prst=null;
		ResultSet rs=null;
		
		List<Repairer> list=new ArrayList<Repairer>();
		String sql="select * from Repairer where repairerID=?";
		Datebase datebase=new Datebase();
		try{
			conn=datebase.getConn();
			prst=conn.prepareStatement(sql);
			prst.setString(1,repairerID);
			rs=prst.executeQuery();//执行查询
			while(rs.next()){//遍历结果集
				
				//建立bean对象
				Repairer repairer=new Repairer();
				
				//将数据装载进Bean对象
				repairer.setRepairerID(rs.getString(1));
				repairer.setPassword(rs.getString(2));
				repairer.setName(rs.getString(3));
				repairer.setSex(rs.getString(4));
				repairer.setPhone(rs.getString(5));
				repairer.setRemarks(rs.getString(6));
				
				list.add(repairer);
										
			}			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return list;
	}

	
	public boolean change(Repairer repairer) {				//修改密码
		boolean flag=false;
		Connection conn=null;
		PreparedStatement prst=null;
		String sql="update Repairer set password=? where repairerID=?";
		//连接数据库
		Datebase datebase=new Datebase();
		//将数据插入数据库
		try{		
			conn=datebase.getConn();
			prst=conn.prepareStatement(sql);
			System.out.println(repairer.getRepairerID()+repairer.getPassword());
			
			prst.setString(1,repairer.getPassword());
			prst.setString(2,repairer.getRepairerID());
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


	public List<Repair> getAllRepair() {					//查看需维修信息
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


	
	
	public boolean dealGz(Repair repair) {					//处理故障
		boolean flag=false;
		Connection conn=null;
		PreparedStatement prst=null;
		String sql="update Repair set remarks='已处理' where repairID=?";
		//连接数据库
		Datebase datebase=new Datebase();
		//将数据插入数据库
		try{		
			conn=datebase.getConn();			
			prst=conn.prepareStatement(sql);
			prst.setString(1,repair.getRepairID());
			
			System.out.println(repair.getRepairID());

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

}
