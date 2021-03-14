package cn.my.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DaoFactory {
	/**通过配置文件得到实现类名称
	 * t通过类的名称，完成创建对象（反射完成！）
	 * 返回具体的UserDao实现类对象
	 * @return
	 */
	private static Properties pro=null;
	static{
		//加载配置文件到Properties对象中
		try {
			InputStream in=DaoFactory.class.getClassLoader().getResourceAsStream("dao.properties");
			pro=new Properties();
			pro.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	public static UserDao getUserDao(){
		/**
		 * 给出一个配置文件，文件中给出UserDao的接口的实现类名称
		 * 该方法获取实现类的名称，通过反射机制完成创建对象；
		 */
		//得到dao实现类名称
		String daoClassName=pro.getProperty("cn.my.dao.UserDao");
		//通过反射机制完成创建对象
		try {
			Class classzz=Class.forName(daoClassName);
			return (UserDao)classzz.newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		
	}
}
