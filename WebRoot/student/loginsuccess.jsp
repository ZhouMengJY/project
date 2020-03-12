<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>      
    <title>学生宿舍管理系统</title>    	
  </head>
  
  <body> 		  
    登录成功
   
    
    <a href="../Student_personalDetail">查询个人信息</a>  
    <a href="../quarykoufen">查询寝室扣分情况</a> 
    <a href="/dormitory/student/Student_breakdownMessage.jsp">故障申报</a>
    <a href="../Student_queryBreakdown">查看故障信息</a>
    <a href="student_xiugaimima.jsp">修改密码</a>
  </body>
</html>
