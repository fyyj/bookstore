package priv.fyyj.store.web.servlet.manager;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import priv.fyyj.store.service.ProductService;

/**
 * 后台系统
 * 删除商品信息的servlet
 * @author fyyj
 */
public class DeleteProductServlet extends HttpServlet {
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
		// 获取请求参数，产品id
		String id = request.getParameter("id");
		ProductService service = new ProductService();
		// 调用service完成添加商品操作
		service.deleteProduct(id);
		response.sendRedirect(request.getContextPath() + "/listProduct");
		return;
	}

}
