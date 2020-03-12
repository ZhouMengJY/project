package com.hnsic.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hnsic.dao.SysadminDao;
import com.hnsic.entity.Admin;
import com.hnsic.entity.Instructor;
import com.hnsic.entity.Repairer;
import com.hnsic.entity.Student;
import com.hnsic.entity.Sysadmin;
import com.hnsic.until.Datebase;

public class SysadminDaoimpl implements SysadminDao{

	public boolean Login(Sysadmin sysadmin) {	//系统管理员登录
		boolean flag=false;
		Connection conn=null;
		PreparedStatement prst=null;
		ResultSet rs=null;
		String sql="select * from Sysadmin where sysadminID=?";
		Datebase datebase=new Datebase();
		try{
			conn=datebase.getConn();
			prst=conn.prepareStatement(sql);
			prst.setString(1, sysadmin.getSysadminID());
			rs=prst.executeQuery();	
			if(rs.next()){
				String realpassword=rs.getString(2);
				
				if(sysadmin.getPassword().equals(realpassword.trim())){
					//登陆成功
					flag=true;
					}else{					
					  //密码错误
						sysadmin.setRemarks("1");				
						}
				}
			else{
				sysadmin.setRemarks("2");//用户名不存在，请重新输入。					
				}	
			
		}catch(SQLException e){
			e.printStackTrace();
		}		
		return flag;	
	}

	public boolean addstudent(Student student) {	//添加学生
		boolean flag=false;
		Connection conn=null;
		PreparedStatement prst=null;
		String sql="insert into Student values(?,?,?,?,?,?,?,?,?,?,?,?)";
		//连接数据库
		Datebase datebase=new Datebase();
		//将数据插入数据库
		try{
			conn=datebase.getConn();
			prst=conn.prepareStatement(sql);
			prst.setString(1,student.getStuID());
			prst.setString(2,student.getPassword());
			prst.setString(3,student.getName());
			prst.setString(4,student.getSex());
			prst.setString(5,student.getDormID());
			prst.setString(6,student.getRoomID());
			prst.setString(7,student.getXueyuan());
			prst.setString(8,student.getMajor());
			prst.setString(9,student.getClasses());
			prst.setString(10,student.getPhone());
			prst.setString(11,student.getBirthday());
			prst.setString(12,student.getRemarks());
			
			int n=prst.executeUpdate();
			if(n>0)
				flag=true;
		}catch(SQLException e){
			e.printStackTrace();
			return flag;
		}
		
		return flag;
	}

	public boolean addinstructor(Instructor instructor) {	//添加辅导员
		boolean flag=false;
		Connection conn=null;
		PreparedStatement prst=null;
		String sql="insert into Instructor values(?,?,?,?,?,?)";
		//连接数据库
		Datebase datebase=new Datebase();
		//将数据插入数据库
		try{
			conn=datebase.getConn();
			prst=conn.prepareStatement(sql);
			prst.setString(1,instructor.getInstructorID());
			prst.setString(2,instructor.getPassword());
			prst.setString(3,instructor.getName());
			prst.setString(4,instructor.getSex());
			prst.setString(5,instructor.getPhone());
			prst.setString(6,instructor.getRemarks());
					
			int n=prst.executeUpdate();
			if(n>0)
				flag=true;
		}catch(SQLException e){
			e.printStackTrace();
			return flag;
		}
		
		return flag;
	}

	public boolean addadmin(Admin admin) {		//添加宿舍管理员
		boolean flag=false;
		Connection conn=null;
		PreparedStatement prst=null;
		String sql="insert into Admin values(?,?,?,?,?,?,?)";
		//连接数据库
		Datebase datebase=new Datebase();
		//将数据插入数据库
		try{
			conn=datebase.getConn();
			prst=conn.prepareStatement(sql);
			prst.setString(1,admin.getAdminID());
			prst.setString(2,admin.getDormID());
			prst.setString(3,admin.getPassword());
			prst.setString(4,admin.getName());
			prst.setString(5,admin.getSex());
			prst.setString(6,admin.getPhone());
			prst.setString(7,admin.getRemarks());
			
			int n=prst.executeUpdate();
			if(n>0)
				flag=true;
		}catch(SQLException e){
			e.printStackTrace();
			return flag;
		}
		
		return flag;
	}

	public List<Instructor> queryinstructor() {	//查询辅导员
		Connection conn=null;
		PreparedStatement prst=null;
		ResultSet rs=null;
		List<Instructor> list=new ArrayList<Instructor>();
		String sql="select * from Instructor";
		//获取数据库连接
		Datebase datebase=new Datebase();
		try{
			conn=datebase.getConn();
			prst=conn.prepareStatement(sql);
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

	public List<Admin> queryadmin() {		//查询宿舍管理员
		Connection conn=null;
		PreparedStatement prst=null;
		ResultSet rs=null;
		List<Admin> list=new ArrayList<Admin>();
		String sql="select * from Admin";
		//获取数据库连接
		Datebase datebase=new Datebase();
		try{
			conn=datebase.getConn();
			prst=conn.prepareStatement(sql);
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

	public List<Student> querystudent() {	//查询学生信息
		Connection conn=null;
		PreparedStatement prst=null;
		ResultSet rs=null;
		List<Student> list=new ArrayList<Student>();
		String sql="select * from Student";
		//获取数据库连接
		Datebase datebase=new Datebase();
		try{
			conn=datebase.getConn();
			prst=conn.prepareStatement(sql);
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

	public boolean modifyinstructor(Instructor instructor) {//更改辅导员信息
		boolean flag=false;
		Connection conn=null;
		PreparedStatement prst=null;
		String sql="update Instructor set password=?,name=?,sex=?,phone=?,remarks=? where instructorID=?";
		//连接数据库
		Datebase datebase=new Datebase();
		//将数据插入数据库
		try{		
			conn=datebase.getConn();
			prst=conn.prepareStatement(sql);	
			
			prst.setString(1,instructor.getPassword());
			prst.setString(2,instructor.getName());
			prst.setString(3,instructor.getSex());
			prst.setString(4,instructor.getPhone());
			prst.setString(5,instructor.getRemarks());
			prst.setString(6,instructor.getInstructorID());
			
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

	public boolean modifyadmin(Admin admin) {	//更改宿舍管理员信息
		boolean flag=false;
		Connection conn=null;
		PreparedStatement prst=null;
		String sql="update Admin set dormID=?,password=?,name=?,sex=?,phone=?,remarks=? where adminID=?";
		//连接数据库
		Datebase datebase=new Datebase();
		//将数据插入数据库
		try{		
			conn=datebase.getConn();
			prst=conn.prepareStatement(sql);	
			
			prst.setString(1,admin.getDormID());
			prst.setString(2,admin.getPassword());
			prst.setString(3,admin.getName());
			prst.setString(4,admin.getSex());
			prst.setString(5,admin.getPhone());
			prst.setString(6,admin.getRemarks());
			prst.setString(7,admin.getAdminID());
			
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

	public boolean modifystudent(Student student) {	//更改学生信息
		boolean flag=false;
		Connection conn=null;
		PreparedStatement prst=null;
		String sql="update Student set password=?,name=?,sex=?,dormID=?,roomID=?,xueyuan=?,major=?,classes=?,phone=?,birthday=?,remarks=? where stuID=?";
		//连接数据库
		Datebase datebase=new Datebase();
		//将数据插入数据库
		try{		
			conn=datebase.getConn();
			prst=conn.prepareStatement(sql);
			
			System.out.println(student.getStuID());
			
			prst.setString(1,student.getPassword());
			prst.setString(2,student.getName());
			prst.setString(3,student.getSex());
			prst.setString(4,student.getDormID());
			prst.setString(5,student.getRoomID());
			prst.setString(6,student.getXueyuan());
			prst.setString(7,student.getMajor());
			prst.setString(8,student.getClasses());
			prst.setString(9,student.getPhone());
			prst.setString(10,student.getBirthday());
			prst.setString(11,student.getRemarks());
			prst.setString(12,student.getStuID());
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

	public boolean modifypassword(Sysadmin sysadmin) {	//修改密码
		boolean flag=false;
		Connection conn=null;
		PreparedStatement prst=null;
		String sql="update Sysadmin set password=? where SysadminID=?";
		//连接数据库
		Datebase datebase=new Datebase();
		//将数据插入数据库
		try{		
			conn=datebase.getConn();
			prst=conn.prepareStatement(sql);			
			
			prst.setString(1,sysadmin.getPassword());
			prst.setString(2,sysadmin.getSysadminID());
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

	public List<Repairer> queryrepairer() {		//查询维修人员信息
		Connection conn=null;
		PreparedStatement prst=null;
		ResultSet rs=null;
		List<Repairer> list=new ArrayList<Repairer>();
		String sql="select * from Repairer";
		//获取数据库连接
		Datebase datebase=new Datebase();
		try{
			conn=datebase.getConn();
			prst=conn.prepareStatement(sql);
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
	
	public boolean modifyrepairer(Repairer repairer) {		//修改维修人员信息
		boolean flag=false;
		Connection conn=null;
		PreparedStatement prst=null;
		String sql="update Repairer set password=?,name=?,sex=?,phone=?,remarks=? where repairerID=?";
		//连接数据库
		Datebase datebase=new Datebase();
		//将数据插入数据库
		try{		
			conn=datebase.getConn();
			prst=conn.prepareStatement(sql);	
			
			prst.setString(1,repairer.getPassword());
			prst.setString(2,repairer.getName());
			prst.setString(3,repairer.getSex());
			prst.setString(4,repairer.getPhone());
			prst.setString(5,repairer.getRemarks());
			prst.setString(6,repairer.getRepairerID());
			
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

	public boolean addrepairer(Repairer repairer) {		//添加维修人员信息
		boolean flag=false;
		Connection conn=null;
		PreparedStatement prst=null;
		String sql="insert into Repairer values(?,?,?,?,?,?)";
		//连接数据库
		Datebase datebase=new Datebase();
		//将数据插入数据库
		try{
			conn=datebase.getConn();
			prst=conn.prepareStatement(sql);
			prst.setString(1,repairer.getRepairerID());
			prst.setString(2,repairer.getPassword());
			prst.setString(3,repairer.getName());
			prst.setString(4,repairer.getSex());
			prst.setString(5,repairer.getPhone());
			prst.setString(6,repairer.getRemarks());
						
			int n=prst.executeUpdate();
			if(n>0)
				flag=true;
		}catch(SQLException e){
			e.printStackTrace();
			return flag;
		}
		
		return flag;
	}

	public boolean deleteinstructor(Instructor instructor) {	//删除辅导员信息
		boolean flag=false;
		Connection conn=null;
		PreparedStatement prst=null;
		String sql="delete from Instructor where instructorID=?";
		//连接数据库
		Datebase datebase=new Datebase();
		//删除数据
		try{		
			conn=datebase.getConn();
			prst=conn.prepareStatement(sql);
			prst.setString(1, instructor.getInstructorID());
			int n=prst.executeUpdate();
			System.out.println(instructor.getInstructorID());
			if(n>0)
				flag=true;
		}catch(SQLException e){
			e.printStackTrace();
			return flag;
		}	
		return flag;
	}

	public boolean deleteinadmin(Admin admin) {		//删除宿舍管理员信息
		boolean flag=false;
		Connection conn=null;
		PreparedStatement prst=null;
		String sql="delete from Admin where adminID=?";
		//连接数据库
		Datebase datebase=new Datebase();
		//删除数据
		try{		
			conn=datebase.getConn();
			prst=conn.prepareStatement(sql);
			prst.setString(1, admin.getAdminID());
			int n=prst.executeUpdate();
			System.out.println(admin.getAdminID());
			if(n>0)
				flag=true;
		}catch(SQLException e){
			e.printStackTrace();
			return flag;
		}	
		return flag;
	}

	public boolean deleterepairer(Repairer repairer) {		//删除后勤维修人员信息
		boolean flag=false;
		Connection conn=null;
		PreparedStatement prst=null;
		String sql="delete from Repairer where repairerID=?";
		//连接数据库
		Datebase datebase=new Datebase();
		//删除数据
		try{		
			conn=datebase.getConn();
			prst=conn.prepareStatement(sql);
			prst.setString(1, repairer.getRepairerID());
			int n=prst.executeUpdate();
			System.out.println(repairer.getRepairerID());
			if(n>0)
				flag=true;
		}catch(SQLException e){
			e.printStackTrace();
			return flag;
		}	
		return flag;
	}
	

}
