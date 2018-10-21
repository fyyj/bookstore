<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<meta charset="utf-8" />
	<title>电子书城</title>
	<link rel="stylesheet" href="css/main.css" type="text/css" />
	<script type="text/javascript">
		var interval;
	window.onload = function() {
		interval = window.setInterval("changeSecond()", 1000);
	};
	function changeSecond() {
		var second = document.getElementById("second");
		var svalue = second.innerHTML;
		svalue = svalue - 1;
		if (svalue == 0) {
			window.clearInterval(interval);
			// 下列两行代码用于获取项目名，例如：bookstore
			var pathName = window.location.pathname.substring(1);   
			var webName = pathName == '' ? '' : pathName.substring(0, pathName.indexOf('/'));
			// 拼接访问路径名，例如：http://localhost:8080/bookstore/index.jsp
			location.href = window.location.protocol + '//' + window.location.host + '/'+ webName + '/client/login.jsp'; 
			return;
		}
	second.innerHTML = svalue;
}
		
	</script>
</head>

<body class="main">
	<jsp:include page="head.jsp" />
	<jsp:include page="menu_search.jsp" />

	<div id="divcontent">
		<table width="850px" border="0" cellspacing="0">
			<tr>
				<td style="padding:30px; text-align:center">
					<table width="60%" border="0" cellspacing="0" style="margin-top:70px">
						<tr>
							<td style="width:98">
								<img src="images/IconTexto_WebDev_009.jpg" width="128" height="128" />
							</td>
							<td style="padding-top:30px">
								<font style="font-weight:bold; color:#FF0000">注册成功！</font><br />
								<br /> 
								<a href="${pageContext.request.contextPath }/myAccount">
									<span id="second">5</span>秒后自动为您转跳回登录页面
								</a>
							</td>
						</tr>
					</table>
					<h1>&nbsp;</h1></td>
			</tr>
		</table>
	</div>
	<jsp:include page="foot.jsp"/>
</body>
</html>
