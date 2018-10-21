package priv.fyyj.store.exception;
/**
 * 通过id查找用户失败异常
 * @author fyyj
 *
 */
public class FindProductByIdException extends Exception {
	private static final long serialVersionUID = 1L;

	public FindProductByIdException() {
		super();
	}

	public FindProductByIdException(String message, Throwable cause) {
		super(message, cause);
	}

	public FindProductByIdException(String message) {
		super(message);
	}

	public FindProductByIdException(Throwable cause) {
		super(cause);
	}
}
