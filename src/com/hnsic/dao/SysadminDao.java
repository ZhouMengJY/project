package com.hnsic.dao;

import java.util.List;

import com.hnsic.entity.Admin;
import com.hnsic.entity.Instructor;
import com.hnsic.entity.Repairer;
import com.hnsic.entity.Student;
import com.hnsic.entity.Sysadmin;

public interface SysadminDao {		//ϵͳ����Ա
	public boolean Login(Sysadmin sysadmin);				//ϵͳ����Ա��¼
	public boolean addstudent(Student student);				//���ѧ��
	public boolean addinstructor(Instructor instructor);	//��Ӹ���Ա
	public boolean addadmin(Admin admin);					//����������Ա
	public boolean addrepairer(Repairer repairer);			//���ά����Ա��Ϣ
	public List<Instructor> queryinstructor();				//��ѯ����Ա
	public List<Admin> queryadmin();						//��ѯ�������Ա
	public List<Repairer> queryrepairer();					//��ѯ�������Ա
	public List<Student> querystudent();					//��ѯѧ��
	public boolean modifyinstructor(Instructor instructor);	//�޸ĸ���Ա��Ϣ
	public boolean modifyadmin(Admin admin);				//�޸��������Ա��Ϣ
	public boolean modifystudent(Student student);			//�޸�ѧ����Ϣ
	public boolean modifyrepairer(Repairer repairer);		//�޸�ά����Ա��Ϣ
	public boolean modifypassword(Sysadmin sysadmin);		//�޸�����	
	public boolean deleteinstructor(Instructor instructor);	//ɾ������Ա��Ϣ
	public boolean deleteinadmin(Admin admin);				//ɾ���������Ա��Ϣ
	public boolean deleterepairer(Repairer repairer);		//ɾ������ά����Ա��Ϣ
	
}
