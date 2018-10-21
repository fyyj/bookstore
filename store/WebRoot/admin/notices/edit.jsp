<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<HTML>
<HEAD>
	<meta http-equiv="Content-Language" content="zh-cn">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</HEAD>
<body>
	<form id="userAction_save_do" name="Form1" 
		action="${pageContext.request.contextPath}/manager/EditNoticeServlet" method="post">
		<input type="hidden" name="id" value="${n.n_id}" /> &nbsp;
		<table cellSpacing="1" cellPadding="5" width="100%" align="center"
			bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
			<tr>
				<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4" height="26">
					<strong>修改公告</strong>
				</td>
			</tr>
			<tr>
				<td align="center" bgColor="RED" class="ta_01">公告标题：</td>
				<td class="ta_01" bgColor="#ffffff" colSpan="3">
					<input type="text" name="title" class="bg" maxlength="10"  value="${n.title }"/>
				</td>
			</tr>
			<tr>
				<td class="ta_01" align="center" bgColor="#f5fafe">公告内容：</td>
				<td class="ta_01" bgColor="#ffffff" colSpan="3">
					<textarea name="details" cols="30" rows="3" style="WIDTH: 96%" >${n.details }</textarea>
				</td>
			</tr>
			<tr>
				<td align="center" colSpan="4" class="sep1"><img
					src="${pageContext.request.contextPath}/admin/images/shim.gif">
				</td>
			</tr>
			<tr>
				<td class="ta_01" style="WIDTH: 100%" align="center" bgColor="#f5fafe" colSpan="4">
					<input type="submit" class="button_ok" value="确定"> 					
				</td>
			</tr>
		</table>
	</form>
</body>
</HTML>