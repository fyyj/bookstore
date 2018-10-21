<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
		<meta charset="UTF-8">
		<title>书城后台管理主页</title>
   </head>
   <c:if test="${hidden==6}">
	<frameset rows="103,*,43" >
	  <frame src="${pageContext.request.contextPath}/admin/login/top.jsp" name="topFrame" >
	  <frameset cols="159,*" >
			<frame src="${pageContext.request.contextPath}/admin/login/left.jsp" name="leftFrame"  scrolling="YES">
			<frame src="${pageContext.request.contextPath}/admin/login/welcome.jsp" name="mainFrame">
	  </frameset>
	  <frame src="${pageContext.request.contextPath}/admin/login/bottom.jsp" name="bottomFrame" >
	</frameset>
   </c:if>

</html>
