<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<HTML>
<HEAD>
	<meta charset="UTF-8">
</HEAD>
<body>
	<form id="userAction_save_do" name="Form1" action="${pageContext.request.contextPath}/manager/AddNoticeServlet" method="post">
		&nbsp;
		<table cellSpacing="1" cellPadding="5" width="100%" align="center"
			bgColor="#eeeeee" style="border: 1px solid " >
			<tr>
				<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
					height="26"><strong>添加公告</strong>
				</td>
			</tr>
			<tr>
				<td align="center" bgColor="#f5fafe" class="ta_01">公告标题：</td>
				<td class="ta_01" bgColor="#ffffff" colSpan="3">
					<input type="text" name="title" class="bg" maxlength="10"/>
				</td>
			</tr>
			<tr>
				<td class="ta_01" align="center" bgColor="#f5fafe">公告内容：</td>
				<td class="ta_01" bgColor="#ffffff" colSpan="3">
					<textarea name="details" cols="30" rows="3" style="WIDTH: 96%"></textarea>
				</td>
			</tr>
			<tr>
				<td align="center" colSpan="4" class="sep1">
					<img src="${pageContext.request.contextPath}/admin/images/shim.gif">
				</td>
			</tr>

			<tr>
				<td class="ta_01" style="WIDTH: 100%" align="center" bgColor="#f5fafe" colSpan="4">
					<input type="submit" class="button_ok" value="确定" />						 
					<!-- <span id="Label1"></span> -->
				</td>
			</tr>
		</table>
	</form>
</body>
</HTML>