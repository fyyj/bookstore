package priv.fyyj.store.web.servlet.client;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import priv.fyyj.store.bean.Notice;
import priv.fyyj.store.exception.NoticeException;
import priv.fyyj.store.service.NoticeService;

/**
 *	前台页面展示的servlet 
 *	展示最新添加或修改的一条公告
 */
public class ShowIndexServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		//查询最近一条公告，传递到index.jsp页面进行展示
		NoticeService nService = new NoticeService();
		try{
			Notice notice = nService.getRecentNotice();
			req.setAttribute("n", notice);		
			//请求转发
			req.getRequestDispatcher("/client/index.jsp").forward(req, resp);
			return;
		} catch (NoticeException e) {
			resp.getWriter().print(e.getMessage());			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
}
