package priv.fyyj.store.bean;
/**
 * 订单条项实体类
 * @author fyyj
 *
 */
public class OrderItem {
	private Order order;//订单
	private Product p;	//商品
	/**
	 * @return the order
	 */
	public Order getOrder() {
		return order;
	}
	/**
	 * @param order the order to set
	 */
	public void setOrder(Order order) {
		this.order = order;
	}
	/**
	 * @return the p
	 */
	public Product getP() {
		return p;
	}
	/**
	 * @param p the p to set
	 */
	public void setP(Product p) {
		this.p = p;
	}
	
}
