package priv.fyyj.store.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import priv.fyyj.store.bean.OrderItem;

public class Order {
	private String id; // 订单编号
	private double money; // 订单总价
	private String receiverAddress; // 送货地址
	private String receiverName; // 收货人姓名
	private String receiverPhone; // 收货人电话
	private int paystate; // 订单状态
	private Date ordertime; // 下单时间
	private User user; // 订单所属用户
	private List<OrderItem> orderItems = new ArrayList<OrderItem>();	//订单条项集合
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the money
	 */
	public double getMoney() {
		return money;
	}

	/**
	 * @param money the money to set
	 */
	public void setMoney(double money) {
		this.money = money;
	}

	/**
	 * @return the receiverAddress
	 */
	public String getReceiverAddress() {
		return receiverAddress;
	}

	/**
	 * @param receiverAddress the receiverAddress to set
	 */
	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}

	/**
	 * @return the receiverName
	 */
	public String getReceiverName() {
		return receiverName;
	}

	/**
	 * @param receiverName the receiverName to set
	 */
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	/**
	 * @return the receiverPhone
	 */
	public String getReceiverPhone() {
		return receiverPhone;
	}

	/**
	 * @param receiverPhone the receiverPhone to set
	 */
	public void setReceiverPhone(String receiverPhone) {
		this.receiverPhone = receiverPhone;
	}

	/**
	 * @return the paystate
	 */
	public int getPaystate() {
		return paystate;
	}

	/**
	 * @param paystate the paystate to set
	 */
	public void setPaystate(int paystate) {
		this.paystate = paystate;
	}

	/**
	 * @return the ordertime
	 */
	public Date getOrdertime() {
		return ordertime;
	}

	/**
	 * @param ordertime the ordertime to set
	 */
	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the orderItems
	 */
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	/**
	 * @param orderItems the orderItems to set
	 */
	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", money=" + money + ", receiverAddress="
				+ receiverAddress + ", receiverName=" + receiverName
				+ ", receiverPhone=" + receiverPhone + ", paystate=" + paystate
				+ ", ordertime=" + ordertime + ", user=" + user
				+ ", orderItems=" + orderItems + "]";
	}
}
