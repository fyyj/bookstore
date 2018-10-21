package priv.fyyj.store.exception;
/**
 * 修改用户信息失败异常
 * @author fyyj
 *
 */
public class ModifyUserException extends Exception {
	private static final long serialVersionUID = 1L;
	public ModifyUserException() {
		super();
	}
	public ModifyUserException(String message) {
		super(message);
	}
	public ModifyUserException(String message, Throwable cause) {
		super(message, cause);
	}
	public ModifyUserException(Throwable cause) {
		super(cause);
	}

}
