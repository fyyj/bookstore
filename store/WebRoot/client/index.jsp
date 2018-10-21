<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<meta charset="utf-8" />
	<title>书城主页</title>
	<%-- 导入css --%>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/client/css/main.css" type="text/css" />
	<!-- 导入首页轮播图css和js脚本 -->
	<link type="text/css" href="${pageContext.request.contextPath }/client/css/autoplay.css" rel="stylesheet" />
	<script type="text/javascript" src="${pageContext.request.contextPath }/client/js/autoplay.js"></script>
</head>

<body class="main">
	<%@include file="head.jsp"%>
	<%@include file="menu_search.jsp" %>
	
	<!-- 图书商场首页轮播图  start -->
	<div id="box_autoplay">
    	<div class="list">
        	<ul>
            	<li><img src="${pageContext.request.contextPath }/client/ad/index_ad1.jpg" width="900" height="335" /></li>
            	<li><img src="${pageContext.request.contextPath }/client/ad/index_ad2.jpg" width="900" height="335" /></li>
            	<li><img src="${pageContext.request.contextPath }/client/ad/index_ad3.jpg" width="900" height="335" /></li>
            	<li><img src="${pageContext.request.contextPath }/client/ad/index_ad4.jpg" width="900" height="335" /></li>
            	<li><img src="${pageContext.request.contextPath }/client/ad/index_ad5.jpg" width="900" height="335" /></li>
        	</ul>
    	</div>
	</div>
	<!-- 图书商场首页轮播图  end -->	
	<div id="divcontent">
		<table width="900px" border="0" cellspacing="0">
			<tr>
				<td width="497">
					<img src="${pageContext.request.contextPath}/client/images/billboard.gif" width="497" height="38" />
					<table cellspacing="0" class="ctl">
						<tr>
							<td width="100" height="100%">${n.title } </td>
							<td width="485" height="100%">${n.details }</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</div>
	<%@ include file="foot.jsp" %>
</body>
</html>
