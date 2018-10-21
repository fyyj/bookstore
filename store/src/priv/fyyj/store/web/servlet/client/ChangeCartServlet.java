package priv.fyyj.store.web.servlet.client;
import java.io.IOException;
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
 * 改变购物车内容的Servlet
 * @author fyyj
 *
 */
public class ChangeCartServlet extends HttpServlet {
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
		// 2.从session中获取购物车.
		HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")
		List<Product> cart = (List<Product>) session.getAttribute("cart");
		Product p = new Product();
		ProductService service = new ProductService();
		try {
			p = service.findProductById(id);
		} catch (FindProductByIdException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		p.setId(id);
		cart.remove(p);
		response.sendRedirect(request.getContextPath() + "/client/cart.jsp");
		return;
	}
}
