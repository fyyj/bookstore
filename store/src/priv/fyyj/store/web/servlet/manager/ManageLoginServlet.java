package priv.fyyj.store.web.servlet.manager;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import priv.fyyj.store.bean.User;
import priv.fyyj.store.exception.LoginException;
import priv.fyyj.store.service.UserService;
/**
 * 后台校验登录信息的Servlet
 * @author fyyj
 *
 */
public class ManageLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String username= req.getParameter("logonName");
		String password = req.getParameter("logonPwd");
		UserService service = new UserService();
		User user = null;
		try {
			user = service.login(username, password);
		} catch (LoginException e) {
			// TODO Auto-generated catch block
			req.setAttribute("wrong", e.getMessage());
			req.getRequestDispatcher("/admin/login/login.jsp").forward(req, resp);
			return;
		}
		String role = user.getRole();
		if("超级用户".equals(role)){
			req.setAttribute("hidden", 6);
			req.getRequestDispatcher("/admin/login/home.jsp").forward(req, resp);
		}else{
			try {
				throw new LoginException("你不是管理员,无法登陆后台");
			} catch (LoginException e) {
				// TODO Auto-generated catch block
				req.setAttribute("msg", 6);
				req.getRequestDispatcher("/admin/login/login.jsp").forward(req, resp);
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}
