<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'RepairPage.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
<form action="" method="post">
 
<table border=1px align="center">
<tr><td colspan="2" align="center" ><font>--------------故障申请---------------</font></td></tr>
<tr><td>修理编号</td><td><input type="text" name="repairID"/></td></tr>
<tr><td>报修者</td><td><input type="text" name="name"/></td></tr>
<tr><td>联系电话</td><td><input type="text" name="phone"/></td></tr>
<tr><td>故障时间</td><td><input type="text" name="time"/></td></tr>
<tr><td>楼栋</td><td><input type="text" name="dormID"/></td></tr>
<tr><td>寝室号</td><td><input type="text" name="roomID"/></td></tr>
<tr><td>故障描述</td><td><input type="text" name="GZmiaoshu"/></td></tr>
<tr><td>备注</td><td><input type="text" name="remarks"/></td></tr>
<tr><td colspan="2" align="center" >
<input type="submit" value="提交"/>
<input type="reset"  value="重置">
</td></tr>
</table>
</form>
  </body>
</html>
