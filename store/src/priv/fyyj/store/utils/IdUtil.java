package priv.fyyj.store.utils;

import java.util.UUID;
/**
 * 生成一个随机数串
 * @author fyyj
 *
 */
public class IdUtil {
	public static String getUUID() {
		return UUID.randomUUID().toString();

	}
}
