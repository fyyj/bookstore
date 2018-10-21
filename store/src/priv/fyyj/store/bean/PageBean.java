package priv.fyyj.store.bean;

import java.io.Serializable;
import java.util.List;

public class PageBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private int currentPage;// 当前页码
	private int totalCount;// 总条数
	private int totalPage;// 总页数
	private int currentCount;// 每页条数
	private List<Product> ps;// 每页显示的数据
	private String category;//类别
	private String searchfield;//模糊搜索的图书名
	/**
	 * @return the currentPage
	 */
	public int getCurrentPage() {
		return currentPage;
	}
	/**
	 * @param currentPage the currentPage to set
	 */
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	/**
	 * @return the totalCount
	 */
	public int getTotalCount() {
		return totalCount;
	}
	/**
	 * @param totalCount the totalCount to set
	 */
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	/**
	 * @return the totalPage
	 */
	public int getTotalPage() {
		return totalPage;
	}
	/**
	 * @param totalPage the totalPage to set
	 */
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	/**
	 * @return the currentCount
	 */
	public int getCurrentCount() {
		return currentCount;
	}
	/**
	 * @param currentCount the currentCount to set
	 */
	public void setCurrentCount(int currentCount) {
		this.currentCount = currentCount;
	}
	/**
	 * @return the ps
	 */
	public List<Product> getPs() {
		return ps;
	}
	/**
	 * @param ps the ps to set
	 */
	public void setPs(List<Product> ps) {
		this.ps = ps;
	}
	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}
	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	/**
	 * @return the searchfield
	 */
	public String getSearchfield() {
		return searchfield;
	}
	/**
	 * @param searchfield the searchfield to set
	 */
	public void setSearchfield(String searchfield) {
		this.searchfield = searchfield;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
