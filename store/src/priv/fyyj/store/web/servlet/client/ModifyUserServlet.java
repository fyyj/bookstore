package priv.fyyj.store.web.servlet.client;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import priv.fyyj.store.bean.User;
import priv.fyyj.store.exception.ModifyUserException;
import priv.fyyj.store.service.UserService;
/**
 * 修改用户信息的Servlets
 * @author fyyj
 *
 */
public class ModifyUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//解决中文乱码问题
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8"); 
		//拿到session域中的user，得到username的值
		User user = (User) req.getSession().getAttribute("user");
		String username = user.getUsername();		
		String email = req.getParameter("textemail");
		String password = req.getParameter("textpwd");
		String gender = req.getParameter("textradio");
		String telephone = req.getParameter("textphone");
		Map<String, String> map = new HashMap<String, String>();
		map.put("username", username);
		map.put("email", email);
		map.put("password", password);
		map.put("gender", gender);
		map.put("telephone", telephone);
		try {
			BeanUtils.populate(user, map);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		UserService service = new UserService();
		try {
			service.modify(user);
			resp.sendRedirect(req.getContextPath() + "/client/modifyusersuccess.jsp");
		} catch (ModifyUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
