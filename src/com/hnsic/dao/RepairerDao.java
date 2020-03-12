package com.hnsic.dao;

import java.util.List;

import com.hnsic.entity.Repair;
import com.hnsic.entity.Repairer;

public interface RepairerDao {
	public boolean Login(Repairer repairer);//辅导员登录	
	public List<Repairer> getRepairer(String repairerID);//查询个人信息
	public boolean change(Repairer repairer);//修改密码
	public List<Repair> getAllRepair();//查询所有故障維修信息
	public boolean dealGz(Repair repair);//处理故障
		
}
