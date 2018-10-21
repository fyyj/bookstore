package priv.fyyj.store.service;

import java.sql.SQLException;

import priv.fyyj.store.bean.User;
import priv.fyyj.store.dao.UserDao;
import priv.fyyj.store.exception.LoginException;
import priv.fyyj.store.exception.ModifyUserException;
import priv.fyyj.store.exception.RegisterException;
/**
 * 用户Service
 * @author fyyj
 *
 */
public class UserService {
	private UserDao dao = new UserDao();
	// 注册操作
	public void register(User user) throws RegisterException {
		// 调用dao完成注册操作
		try {
			dao.addUser(user);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RegisterException("注冊失败,3秒后跳转到注册页面");
		}
	}
	// 登录操作
	public User login(String username, String password)throws LoginException {
		try {
			//根据登录时表单输入的用户名和密码，查找用户
			User user = dao.findUserByUsernameAndPassword(username, password);
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}		
	}
	public void modify(User user) throws ModifyUserException {
		try {
			dao.modify(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
