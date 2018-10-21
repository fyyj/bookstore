package priv.fyyj.store.web.servlet.manager;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import priv.fyyj.store.bean.Notice;
import priv.fyyj.store.service.NoticeService;

/**
 *	后台查询所有公告的servlet
 *	@author fyyj
 */
public class ListNoticeServlet extends HttpServlet{
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
		String error = req.getParameter("msg");
		NoticeService nService = new NoticeService();
		List<Notice> notices;
		try {
			notices = nService.getAllNotices();
			req.setAttribute("notices", notices);
			req.getRequestDispatcher("/admin/notices/list.jsp").forward(req, resp);
		} catch (Exception e) {
			req.setAttribute("error", error);
			req.getRequestDispatcher("/admin/notices/list.jsp").forward(req, resp);
		}		
	}
}
