package priv.fyyj.store.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
/**
 * 数据源工具
 * @author fyyj
 *
 */
public class DataSourceUtil {
	private static DataSource dataSource = new ComboPooledDataSource();
	private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
	public static DataSource getDataSource() {
		return dataSource;
	}
	/**
	 * 得到连接对象
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		//使用ThreadLocal可以保证拿到的是同一个连接
		Connection con = tl.get();
		if (con == null) {
			con = dataSource.getConnection();
			tl.set(con);
		}
		return con;
	}
	/**
	 * 开启事务
	 * @throws SQLException
	 */
	public static void startTransaction() throws SQLException {
		Connection con = getConnection();
		if (con != null)
			con.setAutoCommit(false);
	}
	/**
	 * 结束事务
	 * @throws SQLException
	 */
	public static void releaseAndCloseConnection() throws SQLException {
		Connection con = getConnection();
		if (con != null) {
			con.commit();
			tl.remove();
			con.close();
		}
	}
	/**
	 * 事务回滚
	 * @throws SQLException 
	 */
	public static void rollback() throws SQLException {
		Connection con = getConnection();
		if (con != null) {
			con.rollback();
		}
	}

}
