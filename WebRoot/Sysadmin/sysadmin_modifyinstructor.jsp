<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE>Untitled Page</TITLE>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<STYLE type=text/css> 
{
	FONT-SIZE: 12px
}
.gridView {
	BORDER-RIGHT: #bad6ec 1px; BORDER-TOP: #bad6ec 1px; BORDER-LEFT: #bad6ec 1px; COLOR: #566984; BORDER-BOTTOM: #bad6ec 1px; FONT-FAMILY: Courier New
}
.gridViewHeader {
	BORDER-RIGHT: #bad6ec 1px solid; BORDER-TOP: #bad6ec 1px solid; BACKGROUND-IMAGE: url(${pageContext.request.contextPath }/images/bg_th.gif); BORDER-LEFT: #bad6ec 1px solid; LINE-HEIGHT: 27px; BORDER-BOTTOM: #bad6ec 1px solid
}
.gridViewItem {
	BORDER-RIGHT: #bad6ec 1px solid; BORDER-TOP: #bad6ec 1px solid; BORDER-LEFT: #bad6ec 1px solid; LINE-HEIGHT: 32px; BORDER-BOTTOM: #bad6ec 1px solid; TEXT-ALIGN: center
}
.cmdField {
	BORDER-RIGHT: 0px; BORDER-TOP: 0px; BACKGROUND-IMAGE: url(${pageContext.request.contextPath }/images/bg_rectbtn.png); OVERFLOW: hidden; BORDER-LEFT: 0px; WIDTH: 67px; COLOR: #364c6d; LINE-HEIGHT: 27px; BORDER-BOTTOM: 0px; BACKGROUND-REPEAT: repeat-x; HEIGHT: 27px; BACKGROUND-COLOR: transparent; TEXT-DECORATION: none
}
.buttonBlue {
	BORDER-RIGHT: 0px; BORDER-TOP: 0px; BACKGROUND-IMAGE: url(${pageContext.request.contextPath }/images/bg_button_blue.gif); BORDER-LEFT: 0px; WIDTH: 78px; COLOR: white; BORDER-BOTTOM: 0px; BACKGROUND-REPEAT: no-repeat; HEIGHT: 21px
}
</STYLE>
<META content="MSHTML 6.00.2900.5848" name=GENERATOR>
<%
String path =request.getContextPath();
String basePath = request.getScheme() + "://"
+ request.getServerName() + ":" + request.getServerPort()
+ path + "/";
%>

</HEAD>
<BODY 
style="BACKGROUND-POSITION-Y: -120px; 
BACKGROUND-IMAGE: url(<%=basePath %>/images/bg.gif); 
BACKGROUND-REPEAT: repeat-x">
<SCRIPT type=text/javascript>
//<![CDATA[
var theForm = document.forms['aspnetForm'];
if (!theForm) {
    theForm = document.aspnetForm;
}
function __doPostBack(eventTarget, eventArgument) {
    if (!theForm.onsubmit || (theForm.onsubmit() != false)) {
        theForm.__EVENTTARGET.value = eventTarget;
        theForm.__EVENTARGUMENT.value = eventArgument;
        theForm.submit();
    }
}
//]]>
</SCRIPT>
<SCRIPT src="EmployeeMgr.files/WebResource.axd" type=text/javascript></SCRIPT>
<SCRIPT src="EmployeeMgr.files/ScriptResource.axd" 
type=text/javascript></SCRIPT>
<SCRIPT 
src="C:\Documents and Settings\Administrator\桌面\MyOffice 首页.files\EmployeeMgr.files\ScriptResource(1).axd" 
type=text/javascript></SCRIPT>
<DIV>
  <TABLE height="100%" cellSpacing=0 cellPadding=0 width="100%" border=0>
    <TBODY>
      <TR 
  style="BACKGROUND-IMAGE: url(<%=basePath %>/images/bg_header.gif); BACKGROUND-REPEAT: repeat-x" 
  height="47px">
        <TD width="10px"  ><SPAN 
      style="FLOAT: left; BACKGROUND-IMAGE: url(<%=basePath %>/images/main_hl.gif); WIDTH: 15px; BACKGROUND-REPEAT: no-repeat; HEIGHT: 47px"></SPAN></TD>
        <TD>
 <SPAN style="FLOAT: left; BACKGROUND-IMAGE: url(<%=basePath %>/images/main_hl2.gif); WIDTH: 15px; BACKGROUND-REPEAT: no-repeat; HEIGHT: 47px"></SPAN><SPAN 
      style="PADDING-RIGHT: 10px; PADDING-LEFT: 10px; FLOAT: left; BACKGROUND-IMAGE: url(<%=basePath %>/images/main_hb.gif); 
      PADDING-BOTTOM: 10px; COLOR: white; PADDING-TOP: 10px; BACKGROUND-REPEAT: repeat-x;  TEXT-ALIGN: center; 0px: ">信息浏览</SPAN><SPAN 
      style="FLOAT: left; BACKGROUND-IMAGE: url(<%=basePath %>/images/main_hr.gif); WIDTH: 60px; BACKGROUND-REPEAT: no-repeat; HEIGHT: 47px"></SPAN></TD>
      
      <TD 
    style="BACKGROUND-POSITION: BACKGROUND-IMAGE: url(<%=basePath %>/images/main_rc.gif)" 
    width="10px" height="47px">
    
    </TD>
      </TR>
      <TR>
        <TD style="BACKGROUND-IMAGE: url(<%=basePath %>/images/main_ls.gif);width: 15px"></TD>
        <TD 
    style="PADDING-RIGHT: 10px; PADDING-LEFT: 10px; COLOR: #566984; PADDING-TOP: 10px; BACKGROUND-COLOR: white" 
    vAlign=top align="middle">
<div>   	
<% 
    request.setCharacterEncoding("utf-8");
  	response.setCharacterEncoding("utf-8");
  	
  	//接受表单提交过来的数据
	String instructorID=request.getParameter("instructor.instructorID");
	String password=request.getParameter("instructor.password");
	String name=request.getParameter("instructor.name");
	String sex=request.getParameter("instructor.sex");
	String phone=request.getParameter("instructor.phone");
	String remarks=request.getParameter("instructor.remarks");
	  	
  	%>
  	
  	<form action="/dormitory/Sysadmin_modifyinstructor" method="post">
      	<table border="1" width="80%" align="center">
    		<tr>
    			<td>辅导员编号</td>
    			<td>
    				<input readonly="readonly" type="text" name="instructorID" value="<%=instructorID%>">
    			</td>
    			<td>密码</td>
    			<td>
    				<input type="text" name="password" value="<%=password%>">
    			</td>
    		</tr>
    		<tr>
    			<td>姓名</td>
    			<td>
    				<input type="text" name="name" value="<%=name%>">
    			</td>
    			<td>性别</td>
    			<td>
    				<input type="text" name="sex" value="<%=sex%>">
    			</td>
    		</tr>
    		<tr>
    			<td>电话号码</td>
    			<td>
    				<input type="text" name="phone" value="<%=phone%>">
    			</td>
    			<td>备注</td>
    			<td>
    				<input type="text" name="remarks" value="<%=remarks%>">
    			</td>
    		</tr>
    		<tr>
      	  		<td>
      	  			<input type="submit" value="修改">
      	  		</td>
      	  </tr>
      	</table>
    </form> 
</div>
        </TD>
        <TD style="BACKGROUND-IMAGE: url(<%=basePath %>/images/main_rs.gif);width: 15px"></TD>
      </TR>
      <TR 
  style="BACKGROUND-IMAGE: url(<%=basePath %>/images/main_fs.gif); BACKGROUND-REPEAT: repeat-x" 
  height=10>
        <TD style="BACKGROUND-IMAGE: url(<%=basePath %>/images/main_lf.gif)"><span ></span></TD>
        <TD style="BACKGROUND-IMAGE: url(<%=basePath %>/images/main_fs.gif)"></TD>
        <TD 
style="BACKGROUND-IMAGE: url(<%=basePath %>/images/main_rf.gif)"></TD>
      </TR>
    </TBODY>
  </TABLE>
</DIV>
<SCRIPT type=text/javascript>
//<![CDATA[
Sys.Application.initialize();
//]]>
</SCRIPT>
</BODY>
</HTML>
