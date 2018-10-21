package priv.fyyj.store.web.servlet.manager;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import priv.fyyj.store.bean.Product;
import priv.fyyj.store.service.ProductService;

/**
 * 多条件查询Product的Servlet
 * @author fyyj
 *
 */

public class FindProductByManyConditionServlet extends HttpServlet {
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
		//1.获取表单数据
		String id = request.getParameter("id"); // 商品id
		String name = request.getParameter("name"); // 商品名称
		String category = request.getParameter("category"); // 商品类别
		String minprice = request.getParameter("minprice");//最小价格
		String maxprice = request.getParameter("maxprice");//最大价格
		// 2.创建ProductService对象
		ProductService service = new ProductService();
		// 3.调用service层用于条件查询的方法
		List<Product> ps = service.findProductByManyCondition(id, category, name, minprice, maxprice);
		// 4.将条件查询的结果放进request域中
		request.setAttribute("ps", ps);
		// 5.请求重定向到商品管理首页list.jsp页面
		request.getRequestDispatcher("/admin/products/list.jsp").forward(
				request, response);
	}
}
