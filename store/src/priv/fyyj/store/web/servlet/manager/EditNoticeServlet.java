package priv.fyyj.store.web.servlet.manager;

import java.io.IOException;
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
public class EditNoticeServlet extends HttpServlet{
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
		Notice notice = new Notice();
		//获取表单参数
		int n_id = Integer.parseInt(req.getParameter("id"));
		String title = req.getParameter("title");
		String details = req.getParameter("details");		
		//将当前时间格式化
		String t = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());		
		notice.setN_id(n_id);
		notice.setTitle(title);
		notice.setDetails(details);
		//将当前时间设为添加公告的时间
		notice.setN_time(t);		
		//调用dao层方法
		nService.updateNotice(notice);
		req.getRequestDispatcher("/manager/ListNoticeServlet").forward(req, resp);
	}
}
