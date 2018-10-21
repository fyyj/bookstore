package priv.fyyj.store.web.servlet.manager;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import priv.fyyj.store.bean.Product;
import priv.fyyj.store.exception.FindProductByIdException;
import priv.fyyj.store.service.ProductService;
/**
 * 后台用于修改Product信息的Servlet
 * @author fyyj
 *
 */
public class ModifyProductByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//处理中文乱码
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		//获取商品id
		String id = req.getParameter("id");
		try {//查询商品
			Product p = new ProductService().findProductById(id);
			req.setAttribute("p", p);
			req.getRequestDispatcher("/admin/products/edit.jsp").forward(req, resp);
		} catch (FindProductByIdException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
