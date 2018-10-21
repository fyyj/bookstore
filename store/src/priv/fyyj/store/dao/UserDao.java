package priv.fyyj.store.dao;

import java.sql.SQLException;
import java.util.Date;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import priv.fyyj.store.bean.User;
import priv.fyyj.store.exception.LoginException;
import priv.fyyj.store.exception.ModifyUserException;
import priv.fyyj.store.utils.DataSourceUtil;
/**
 * 用户
 * @author fyyj
 *
 */
public class UserDao {
		// 添加用户
		public void addUser(User user) throws SQLException {
			String sql = "insert into user(username,password,gender,email,telephone,introduce,role,registTime) values(?,?,?,?,?,?,?,?)";
			QueryRunner runner = new QueryRunner(DataSourceUtil.getDataSource());
			int row = runner.update(sql, user.getUsername(), user.getPassword(),
					user.getGender(), user.getEmail(), user.getTelephone(),
					user.getIntroduce(),"普通用户",new Date());
			if (row == 0) {
				throw new RuntimeException();
			}
		}		
		//根据用户名与密码查找用户
		public User findUserByUsernameAndPassword(String username, String password) throws SQLException, LoginException {
			String sql="select * from user where username=? and password=?";
			QueryRunner runner = new QueryRunner(DataSourceUtil.getDataSource());	
			User user = runner.query(sql, new BeanHandler<User>(User.class),username,password);
			if(user==null) {
				throw new LoginException("用户未找到,请检查您的账号和密码");
			}
			return user;
		}
		//修改用户信息
		public void modify(User user) throws SQLException, ModifyUserException {
			String sql = "update user set  password=?, gender = ? "
					+ ", email=?,  telephone=? where username = ?";
			QueryRunner runner = new QueryRunner(DataSourceUtil.getDataSource());
			int row = runner.update(sql,  user.getPassword(), user.getGender(), user.getEmail()
							,user.getTelephone(), user.getUsername());
			if(row==0) {
				throw new ModifyUserException("修改用户信息失败");
			}
		}
}
