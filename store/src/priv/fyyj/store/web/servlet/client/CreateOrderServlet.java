package priv.fyyj.store.web.servlet.client;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import priv.fyyj.store.bean.Order;
import priv.fyyj.store.bean.OrderItem;
import priv.fyyj.store.bean.Product;
import priv.fyyj.store.bean.User;
import priv.fyyj.store.service.OrderService;
import priv.fyyj.store.utils.IdUtil;

/**
 * 生成订单
 * @author fyyj
 *
 */
public class CreateOrderServlet extends HttpServlet {
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
		// 1.得到当前用户
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		//如果用户还没有登录，重定向到登录页面
		if(user== null) {
			request.setAttribute("error", "error");
			request.getRequestDispatcher("/client/login.jsp").forward(request, response);
			return;
		}
		// 2.从购物车中获取商品信息
		@SuppressWarnings("unchecked")
		List<Product> cart = (List<Product>)session.getAttribute("cart");
		// 3.将数据封装到订单对象中
		Order order = new Order();
		try {
			BeanUtils.populate(order, request.getParameterMap());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		order.setId(IdUtil.getUUID());// 封装订单id
		order.setUser(user);// 封装用户信息到订单
		for (Product p : cart) {
			OrderItem item = new OrderItem();
			item.setOrder(order);
			item.setP(p);
			order.getOrderItems().add(item);
		}
		// 4.调用service中添加订单操作.
		OrderService service = new OrderService();
		service.addOrder(order);
		response.sendRedirect(request.getContextPath() + "/client/createOrderSuccess.jsp");
	}

}
