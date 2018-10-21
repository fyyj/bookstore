package priv.fyyj.store.web.servlet.client;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import priv.fyyj.store.service.OrderService;


/**
 * 前台 订单列表页面删除订单的Servlet
 * @author fyyj
 *
 */
public class DelOrderByIdServlet extends HttpServlet {
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
		// 订单id
		String id = request.getParameter("id");
		OrderService service = new OrderService();
		// 调用service层方法删除相应订单
		service.delOrderByIdWithClient(id);
		response.sendRedirect(request.getContextPath() + "/client/delOrderSuccess.jsp");;
		return;
	}
}
