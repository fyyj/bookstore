package priv.fyyj.store.web.servlet.client;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import priv.fyyj.store.bean.Order;
import priv.fyyj.store.service.OrderService;

/**
 * 通过id查询订单的Servlet
 * @author fyyj
 *
 */
public class FindOrderByIdServlet extends HttpServlet {
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
		//1.得到要查询的订单的id
		String id = request.getParameter("id");
		//2.根据id查找订单
		OrderService service = new OrderService();
		Order order = service.findOrderById(id);
        //3.将查询出的订单信息添加到request作用域中
		request.setAttribute("order", order);
		//4.请求转发orderInfo.jsp
		request.getRequestDispatcher("/client/orderInfo.jsp").forward(request, response);
	}

}
