<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<meta charset="utf-8" />
<title>书城</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/client/css/main.css" type="text/css" />
<script>
	//删除购物车中的商品
	function cart_del() {   
	    var msg = "您确定要删除该商品吗？";   
	    if (confirm(msg)==true){   
	    return true;   
	    }else{   
	    return false;   
	    }   
	}   
</script>
</head>
<body class="main">
	<p:user/>
	<jsp:include page="head.jsp" />
	<jsp:include page="menu_search.jsp" />
	<div id="divpagecontent">
		<table width="100%" border="0" cellspacing="0">
			<tr>
				<td>
					<div style="text-align:right; margin:5px 10px 5px 0px">
						<a href="${pageContext.request.contextPath }/index.jsp">首页</a>
						&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;购物车
					</div>
					<table cellspacing="0" class="infocontent">
						<tr>
							<td>
								<img src="${pageContext.request.contextPath}/client/ad/page_ad.jpg" width="890" height="89" />
								<table width="100%" border="0" cellspacing="0">
									<tr>
										<td>
											<img src="${pageContext.request.contextPath}/client/images/buy1.gif" width="635" height="38" />
										</td>
									</tr>
									<tr>
										<td>
											<table cellspacing="1" class="carttable">
												<tr>
													<td width="10%">序号</td>
													<td width="30%">商品名称</td>
													<td width="10%">价格</td>
													<td width="20%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;数量</td>
													<td width="10%">库存</td>
													<td width="10%">小计</td>
													<td width="10%">取消</td>
												</tr>
											</table>
											<!-- 循环输出商品信息 -->
											<c:set var="total" value="0" /> 
											<c:forEach items="${cart}" var="entry" varStatus="vs">
												<table width="100%" border="0" cellspacing="0">
													<tr>
														<td width="10%">${vs.count}</td>
														<td width="30%">${entry.name }</td>
														<td width="10%">${entry.price }</td>
														<td width="20%">
														    <!-- 商品数量显示 -->
															<input name="text" type="text" value=1 style="width:40px;text-align:center" />
														</td>
														<td width="10%">${entry.pnum}</td>
														<td width="10%">${entry.price}</td>
														<td width="10%">
														    <!-- 删除商品 -->
															<a href="${pageContext.request.contextPath}/changeCart?id=${entry.id}"
															style="color:#FF0000; font-weight:bold" onclick="javascript:return cart_del()">X</a>
														</td>
													</tr>
												</table>
												<c:set value="${total+entry.price}" var="total" />
											</c:forEach>

											<table cellspacing="1" class="carttable">
												<tr>
													<td style="text-align:right; padding-right:40px;">
														<font style="color:#FF6600; font-weight:bold">合计：&nbsp;&nbsp;${total}元</font>
													</td>
												</tr>
											</table>
											<div style="text-align:right; margin-top:10px">
											    <!--继续购物 -->
												<a href="${pageContext.request.contextPath}/showProductByPage">
													<img src="images/gwc_jx.gif"/>
												</a>
												&nbsp;&nbsp;&nbsp;&nbsp;
                                                 <!--结账 -->
												<a href="${pageContext.request.contextPath}/client/order.jsp">
													<img src="${pageContext.request.contextPath}/client/images/gwc_buy.gif"  />
												</a>
											</div>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</div>
	<jsp:include page="foot.jsp" />
</body>
</html>
