package priv.fyyj.store.exception;
/**
 * 后台查询商品信息失败异常
 * @author fyyj
 *
 */
public class ListProductException extends Exception {
	private static final long serialVersionUID = 1L;

	public ListProductException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ListProductException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ListProductException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ListProductException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
}
