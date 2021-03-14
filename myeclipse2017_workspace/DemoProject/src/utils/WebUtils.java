package utils;

import java.util.UUID;
/**
 * 随机生成一个在数据库唯一id
 * @author Administrator
 *
 */
public class WebUtils {

	public static String makeID(){
		return UUID.randomUUID().toString();
	}
}
