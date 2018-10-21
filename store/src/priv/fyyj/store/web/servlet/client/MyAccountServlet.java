package priv.fyyj.store.web.servlet.client;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import priv.fyyj.store.bean.User;

/**
 * 校验用户是否登录Servlet
 * @author fyyj
 *
 */
public class MyAccountServlet extends HttpServlet {
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
		/**
		 * 点击前台系统中的【我的账户】，分以下两种情况：
		 * 1、用户未登录，进入登录页面
		 * 2、用户已登录,登录到我的账户
		 */
		//在session中查找名为“user”的会话
		User user = (User) request.getSession().getAttribute("user");
		//如果找到没有名为“user”的会话，说明用户没有登录，此时跳转到登录页面
		if (user == null) {
			response.sendRedirect(request.getContextPath() + "/client/login.jsp");
			return;
		}
		response.sendRedirect(request.getContextPath() + "/client/myAccount.jsp");
	}
}