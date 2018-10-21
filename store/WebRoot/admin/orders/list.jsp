<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<HTML>
<HEAD>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script type="text/javascript">
	//删除订单
	function o_del() {   
		var msg = "您确定要删除该订单吗？";   
		if (confirm(msg)==true){   
		return true;   
		}else{   
		return false;   
		}   
	}   
	</script>
</HEAD>
<body>
	<br />
	<form id="Form1"  action="${pageContext.request.contextPath}/findOrderByManyCondition" method="post">
		<table cellSpacing="1" width="100%" align="center" >
				<tr>
					<td align="center" bgColor="#afd1f3">
					<!-- <strong>标签用于强调文本 -->
						<strong>查 询 条 件</strong>
					</td>
				</tr>
				<tr>
					<td>
						<table>
							<tr>
								<td height="22" align="center" bgColor="#f5fafe">
									订单编号</td>
								<td  bgColor="#ffffff">
									<input type="text" name="id" size="15" value="" id="Form1_userName"/>
								</td>
								<td height="22" align="center" bgColor="#f5fafe" >
									收件人：</td>
								<td class="ta_01" bgColor="#ffffff">
									<input type="text"  size="15" value="" id="Form1_userName"  />
								</td>
							</tr>
							<tr>
								<td height="22" align="center" bgColor="#f5fafe" ></td>
								<td bgColor="#ffffff">
									
								</td>
								<td align="right" bgColor="#ffffff" >
									<br /><br />
								</td>
								<td align="center" bgColor="#ffffff" >
									<button type="submit" id="search" name="search" value="&#26597;&#35810;" class="button_view">
										&#26597;&#35810;
									</button> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td  align="center" bgColor="#afd1f3">
						<strong>订 单 列 表</strong>
					</td>
				</tr>
				<tr>
					<td  align="right"></td>
				</tr>
				<tr>
					<td  align="center" bgColor="#f5fafe">
						<table cellspacing="0" cellpadding="1" rules="all"
							bordercolor="gray" border="1" id="DataGrid1"
							style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
							<tr style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">
								<td align="center" width="20%">订单编号</td>
								<td align="center" width="10%">收件人</td>
								<td align="center" width="15%">地址</td>
								<td align="center" width="10%">联系电话</td>
								<td width="11%" align="center">总价</td>
								<td width="8%" align="center">所属用户</td>
								<td width="10%" align="center">订单状态</td>
								<td width="7%" align="center">删除</td>
							</tr>
							<c:forEach items="${orders}" var="order">
								<tr >
									<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="20%">${order.id}</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="10%">${order.receiverName}</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="15%">${order.receiverAddress }</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="10%">${order.receiverPhone }</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center">${order.money}</td>
									<td width="8%" align="center">${order.user.username}</td>
									<td width="10%" align="center">${order.paystate==0?"未支付":"已支付"}</td>
									
									<td align="center" style="HEIGHT: 22px">
                                        <!--  已支付，弹出提示框由操作人确认 -->
									    <c:if test="${order.paystate!=0 }">
											<a href="${pageContext.request.contextPath}/deleteOrderById?id=${order.id}" onclick="javascript:return o_del()">
												<img src="${pageContext.request.contextPath}/admin/images/i_del.gif" width="16" height="16" style="CURSOR: hand">
											</a>
										</c:if> 
										<!--  未支付 ，不能删除-->
										<c:if test="${order.paystate==0 }">
											<a href="javascript:alert('不能删除未支付订单')">
												<img src="${pageContext.request.contextPath}/admin/images/i_del.gif" width="16" height="16" style="CURSOR: hand">
											</a>
										</c:if>
									</td>
								</tr>
							</c:forEach>
						</table>
					</td>
				</tr>
		</table>
	</form>
</body>
</HTML>