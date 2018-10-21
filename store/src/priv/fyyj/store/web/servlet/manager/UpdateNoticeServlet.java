package priv.fyyj.store.web.servlet.manager;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import priv.fyyj.store.bean.Notice;
import priv.fyyj.store.service.NoticeService;

/**
 * 后台修改公告的servlet
 *	@author fyyj
 */
public class UpdateNoticeServlet extends HttpServlet{

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
		NoticeService nService = new NoticeService();
		Notice bean = new Notice();
		//获取表单参数
		String title = req.getParameter("title");
		String details = req.getParameter("details");
		
		//将当前时间设为添加公告的时间
		String t = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		bean.setTitle(title);
		bean.setDetails(details);
		bean.setN_time(t);
		//调用dao层方法
		try {
			nService.addNotice(bean);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			resp.getWriter().print(e.getMessage());
		}
		
		req.getRequestDispatcher("/manager/ListNoticeServlet").forward(req, resp);
	}
}
