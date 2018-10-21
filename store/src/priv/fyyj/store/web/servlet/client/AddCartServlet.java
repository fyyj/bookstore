package priv.fyyj.store.web.servlet.client;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import priv.fyyj.store.bean.Product;
import priv.fyyj.store.exception.FindProductByIdException;
import priv.fyyj.store.service.ProductService;
/**
 * 添加商品到购物车的Servlet
 * @author fyyj
 *
 */

public class AddCartServlet extends HttpServlet {
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
		// 1.得到商品id
		String id = request.getParameter("id");
		// 2.调用service层方法，根据id查找商品
		ProductService service = new ProductService();
		try {
			Product p = service.findProductById(id);
			//3.将商品添加到购物车
			//3.1获得session对象
			HttpSession session = request.getSession();
			//3.2从session中获取购物车对象
			List<Product> cart = (List<Product>)session.getAttribute("cart");
			//3.3如果购物车为null,说明没有商品存储在购物车中
			if (cart == null) {
				//创建出购物车
				cart = new ArrayList<Product>();
			}
			//3.4向购物车中添加商品
			cart.add(p);	
			//4.把购物车存储到session域对象里
			session.setAttribute("cart", cart);
			//5.重定向到cart.jsp
			response.sendRedirect(request.getContextPath() + "/client/cart.jsp");
			return;
		} catch (FindProductByIdException e) {
			e.printStackTrace();
		}
	}
}
