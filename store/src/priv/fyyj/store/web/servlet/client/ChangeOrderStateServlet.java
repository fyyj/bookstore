package priv.fyyj.store.web.servlet.client;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import priv.fyyj.store.service.OrderService;

/**
 * 用户支付过后改变支付状态的Servlet
 * @author fyyj
 *
 */
public class ChangeOrderStateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		// 获得订单号数据
		String orderid = request.getParameter("orderid");
		String paySuccess = "恭喜您支付成功！";
		if (null != orderid) {
				OrderService service = new OrderService();
				// 根据订单号修改订单状态
				try {
					service.updateState(orderid);
					request.setAttribute("paySuccess", paySuccess);
					request.getRequestDispatcher("/findOrderByUser").forward(request, response);
				} catch (Exception e) {
					e.printStackTrace();
					response.getWriter().write("修改订单状态失败");
				}
			}
	}
}
