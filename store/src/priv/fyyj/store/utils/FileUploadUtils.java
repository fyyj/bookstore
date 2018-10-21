package priv.fyyj.store.utils;

import java.util.UUID;

/**
 * 生成随机文件名和二级目录
 * @author fyyj
 *
 */
public class FileUploadUtils {
	 // 截取真实文件名
	public static String subFileName(String fileName) {
		// 查找最后一个 \出现位置
		int index = fileName.lastIndexOf("\\");
		if (index == -1) {
			return fileName;
		}
		return fileName.substring(index + 1);
	}

	// 获得随机UUID文件名
	public static String generateRandonFileName(String fileName) {
		// 获得扩展名
		int index = fileName.lastIndexOf(".");
		if (index != -1) {
			String ext = fileName.substring(index);
			return UUID.randomUUID().toString() + ext;
		}
		return UUID.randomUUID().toString();
	}
	// 获得hashcode生成二级目录
	public static String generateRandomDir(String uuidFileName) {
		int hashCode = uuidFileName.hashCode();
		// 一级目录
		int d1 = hashCode & 0xf; //得到名为1到16的下级文件夹
		// 二级目录
		int d2 = (hashCode >> 4) & 0xf;//得到名为1到16的下下级文件夹
		return "/" + d1 + "/" + d2;
	}
}
