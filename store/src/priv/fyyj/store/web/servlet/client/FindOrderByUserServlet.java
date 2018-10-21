package priv.fyyj.store.web.servlet.client;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import priv.fyyj.store.bean.Order;
import priv.fyyj.store.bean.User;
import priv.fyyj.store.service.OrderService;

/**
 * 通过User查询订单的Servlet
 * @author fyyj
 *
 */
public class FindOrderByUserServlet extends HttpServlet {
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
		// 获取名为“user”的session
		User user = (User) request.getSession().getAttribute("user");
		// 调用service中的方法,根据用户信息查找订单
		OrderService service = new OrderService();
		List<Order> orders = service.findOrderByUser(user);
		request.setAttribute("orders", orders);
		request.getRequestDispatcher("/client/orderlist.jsp").forward(request, response);
	}
}
