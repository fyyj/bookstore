package priv.fyyj.store.bean;

public class Notice {
	private int n_id;
	private String title;
	private String details;
	private String n_time;
	/**
	 * @return the n_id
	 */
	public int getN_id() {
		return n_id;
	}
	/**
	 * @param n_id the n_id to set
	 */
	public void setN_id(int n_id) {
		this.n_id = n_id;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the details
	 */
	public String getDetails() {
		return details;
	}
	/**
	 * @param details the details to set
	 */
	public void setDetails(String details) {
		this.details = details;
	}
	/**
	 * @return the n_time
	 */
	public String getN_time() {
		return n_time;
	}
	/**
	 * @param n_time the n_time to set
	 */
	public void setN_time(String n_time) {
		this.n_time = n_time;
	}
	@Override
	public String toString() {
		return "n_id =" + n_id + "title" + title + "details" + details + "n_time" + n_time;		
	}
}
