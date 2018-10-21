package priv.fyyj.store.service;

import java.sql.SQLException;
import java.util.List;

import priv.fyyj.store.bean.Notice;
import priv.fyyj.store.dao.NoticeDao;
import priv.fyyj.store.exception.NoticeException;
/**
 * 公告Service
 * @author fyyj
 *
 */
public class NoticeService {
	private NoticeDao dao = new NoticeDao();
	//后台系统，查询所有公告
	public List<Notice> getAllNotices()  {
		try {
			return dao.getAllNotices();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	//后台系统，添加公告
	public void addNotice(Notice notice) throws SQLException {
		try {
			dao.addNotice(notice);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//后台系统，根据id查找公告
	public Notice findNoticeById(String n_id) {
		try {
			return dao.findNoticeById(n_id);
		} catch (SQLException e) {
			throw new RuntimeException("根据id查找公告失败！");
		}
	}
	
	//后台系统，根据id修改公告
	public void updateNotice(Notice notice) {
		try {
			dao.updateNotice(notice);
		} catch (SQLException e) {
//			throw new RuntimeException("根据id修改公告失败！");
			e.printStackTrace();
		}
	}
	
	//后台系统，根据id删除公告
	public void deleteNotice(String n_id) {
		try {
			dao.deleteNotice(n_id);
		} catch (SQLException e) {
			throw new RuntimeException("根据id删除公告失败！");
		}
	}
	
	//前台系统，查询最新添加或修改的一条公告
	public Notice getRecentNotice() throws SQLException,NoticeException {
		try {
			return dao.getRecentNotice();
		} catch (SQLException e) {
			throw new NoticeException("查询公告失败");
		}
	}

}
