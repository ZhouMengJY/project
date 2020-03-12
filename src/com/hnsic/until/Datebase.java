package com.hnsic.until;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

	public class Datebase {
		private String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		private String url="jdbc:sqlserver://localhost:1433;DatabaseName=DormitoryDB";
		private String user="sa";
		private String pwd="123456";
		
		//创建获取连接对象的方法
		public Connection getConn(){
			Connection conn=null;		
			try {
				//1、加载驱动
				Class.forName(driver);
				System.out.println("加载驱动成功。");
				//2、生成连接对象
				conn=DriverManager.getConnection(url,user,pwd);
				System.out.println("连接数据库成功。");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return conn;
		}
		
		//清空资源的方法
		public void closeAll(ResultSet rs,Statement stmt,Connection conn){
			if(rs!=null)
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(stmt!=null)
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		//封装增删改操作的方法
		public int update(String sql){
			int i=0;
			//1/2得到连接对象
			Connection conn=getConn();
			//3 发送SQL语句，得到结果
			Statement stmt=null;
			try {
				stmt=conn.createStatement();
				i=stmt.executeUpdate(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//5 清空资源
			closeAll(null,stmt,conn);
			return i;
		}
		
		//封装增删改操作的方法
		public int update(String sql,Object[]params){
			int i=0;
			//1/2得到连接对象
			Connection conn=getConn();
			//3 发送SQL语句，得到结果
			PreparedStatement stmt=null;
			try {
				stmt=conn.prepareStatement(sql);
				for(int n=0;n<params.length;n++){
					stmt.setObject(n+1, params[n]);
				}			
				i=stmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//5 清空资源
			closeAll(null,stmt,conn);
			return i;
		}
	}



