<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>书城</title>
	<meta charset="utf-8">
</head>
<body class="main">
	<div id="divcontent">
		<table width="850px">
			<tr>
				<td style="padding:30px; text-align:center">
					<table width="60%" border="0" cellspacing="0" style="margin-top:70px">
						<tr>
							<td style="width:98">
								<img src="../images/error.jpg" width="128" height="128" />
							</td>
							<td style="padding-top:30px"><font
								style="font-weight:bold; color:#ff0000">权限不足,请登录后操作</font><br />
								<br /> 
								<a href="${pageContext.request.contextPath }/index.jsp">
									<span id="second">5</span>秒后自动为您转跳回首页
								</a>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>
