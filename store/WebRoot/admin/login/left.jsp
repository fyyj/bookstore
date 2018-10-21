<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>菜单</title>
</head>
	<body>			 
		  <a href="${pageContext.request.contextPath}/listProduct" target="mainFrame">商品管理</a>
		  <br/><br/><br/>			  
		  <a href="${pageContext.request.contextPath}/findOrders" target="mainFrame">订单管理</a>			  
		  <br/><br/><br/>			  
		  <a href="${pageContext.request.contextPath}/manager/ListNoticeServlet" target="mainFrame" >公告管理</a>
		  <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
	</body>
</html>
