package priv.fyyj.store.service;

import java.sql.SQLException;
import java.util.List;

import priv.fyyj.store.bean.Order;
import priv.fyyj.store.bean.OrderItem;
import priv.fyyj.store.bean.User;
import priv.fyyj.store.dao.OrderDao;
import priv.fyyj.store.dao.OrderItemDao;
import priv.fyyj.store.utils.DataSourceUtil;
/**
 * 订单Service
 * @author fyyj
 *
 */
public class OrderService {
	private OrderItemDao oidao = new OrderItemDao();
	private OrderDao odao = new OrderDao();
	// 1.添加订单
	public void addOrder(Order order) {
		try {// 1.开启事务
			DataSourceUtil.startTransaction();
			// 2.1向orders表中添加数据
			odao.addProduct(order);
			// 2.2向orderItem表中添加数据
			oidao.addOrderItem(order);
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				DataSourceUtil.rollback(); // 事务回滚
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				// 关闭，释放以及提交事务
				DataSourceUtil.releaseAndCloseConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	// 根据用户查找订单
	public List<Order> findOrderByUser(User user) {
		List<Order> orders = null;
		try {
			// 查找出订单信息
			orders = odao.findOrderByUser(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orders;
	}
	// 根据id查找订单
	public Order findOrderById(String id) {
		Order order = null;
		try {
			order = odao.findOrderById(id);
			List<OrderItem> items = oidao.findOrderItemByOrder(order);
			order.setOrderItems(items);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return order;
	}
	// 查找所有订单
	public List<Order> findAllOrder() {
		List<Order> orders = null;
		try {
			// 查找出订单信息
			orders = odao.findAllOrder();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orders;
	}
	// 支付成功后修改订单状态
	public void updateState(String id) {
		try {
			odao.updateOrderState(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// 多条件查询订单信息
	public List<Order> findOrderByManyCondition(String id, String receiverName, String category, String minprice, String maxprice) {
		List<Order> orders = null;
		try {
			orders = odao.findOrderByManyCondition(id, category, receiverName, minprice, maxprice);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orders;
	}
	//根据id删除订单 
	public void delOrderById(String id) {			
		try {
			DataSourceUtil.startTransaction();//开启事务
			oidao.delOrderItems(id);
			odao.delOrderById(id);
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				DataSourceUtil.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally{
			try {
				DataSourceUtil.releaseAndCloseConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
	}
	public void delOrderByIdWithClient(String id) {
		try {
			DataSourceUtil.startTransaction();//开启事务
			//从订单项中查找商品购买数量
			Order order=new Order();
			order.setId(id);
			List<OrderItem> items=oidao.findOrderItemByOrder(order);
			//修改商品数量								
			oidao.delOrderItems(id); //删除订单项
			odao.delOrderById(id); //删除订单
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				DataSourceUtil.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally{
			try {
				DataSourceUtil.releaseAndCloseConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
