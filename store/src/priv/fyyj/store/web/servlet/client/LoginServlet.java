package priv.fyyj.store.web.servlet.client;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import priv.fyyj.store.bean.User;
import priv.fyyj.store.exception.LoginException;
import priv.fyyj.store.service.UserService;

/**
 * 用于校验用户是否注册的Servlet
 * @author fyyj
 *
 */
public class LoginServlet extends HttpServlet {
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
		// 1.获取登录页面输入的用户名与密码
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String checkbox = request.getParameter("checkbox");
		String checkbox2 = request.getParameter("checkbox2");
		UserService service = new UserService();
		if(checkbox2.equals("checkbox2")) {
			Cookie[] cookies = request.getCookies();
			for(Cookie cookie : cookies) {
				cookie = new Cookie("name", null);
			}
		}
		//实现自动登录，不需要输入密码
		if("checkbox".equals(checkbox)) {
			Cookie ucookie = new Cookie(username, password);
			Cookie mcookie = new Cookie("name", username);			
			//一天之内都可以自动登录			
			ucookie.setMaxAge(60*60*24);
			mcookie.setMaxAge(60*60*24);
			response.addCookie(mcookie);
			response.addCookie(ucookie);
		//如果用户名或者密码为空，拿到cookie
		}else if(username=="" || password=="") {
			Cookie[] cookies = request.getCookies();
			//如果cookie不为空，遍历cookie数组
			if(cookies != null && cookies.length>0) {
				for(Cookie cookie : cookies) {
					//拿到存放username的cookie
					if("name".equals(cookie.getName())) {
						username = cookie.getValue();
						//拿到存放password的cookie
						for(Cookie ck : cookies) {
							if((ck.getName()).equals(username)) {
								password = ck.getValue();
								break;
							}
						}						
					}
				}	
			}else {//没输入用户名，也找不到对应的cookie回显错误信息
				response.setHeader("Refresh", "3,url=http://localhost:8080/store/login.jsp");
				System.out.println("NO");
			}
		}
		// 2.调用service完成登录操作。
		try {
			User user = service.login(username, password);			
			// 3.登录成功，将用户存储到session中.
			request.getSession().setAttribute("user", user);
			response.sendRedirect(request.getContextPath() + "/client/myAccount.jsp");			
		} catch (LoginException e) {
			// 如果出现问题，将错误信息存储到request范围，并跳转回登录页面显示错误信息
			e.printStackTrace();
			request.setAttribute("register_message", e.getMessage());
			request.getRequestDispatcher("/client/login.jsp").forward(request, response);
			return;
		}catch(NullPointerException e) {
			e.printStackTrace();
		}
	}
}