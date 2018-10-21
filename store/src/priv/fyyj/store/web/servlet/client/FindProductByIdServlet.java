package priv.fyyj.store.web.servlet.client;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import priv.fyyj.store.bean.Product;
import priv.fyyj.store.exception.FindProductByIdException;
import priv.fyyj.store.service.ProductService;

/**
 * 根据商品id查找指定商品信息的servlet
 * @author fyyj
 */
public class FindProductByIdServlet extends HttpServlet {
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
		// 得到商品的id
		String id = request.getParameter("id");
		ProductService service = new ProductService();		
		try {
			// 调用service层方法，通过id查找商品
			Product p = service.findProductById(id);
			request.setAttribute("p", p);
			request.getRequestDispatcher("/client/info.jsp").forward(request, response);
			return;
		} catch (FindProductByIdException e) {
			e.printStackTrace();
		}
	}
}
