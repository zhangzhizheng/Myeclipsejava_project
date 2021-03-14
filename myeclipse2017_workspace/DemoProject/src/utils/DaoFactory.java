package utils;
/*
 * 该方法获取实现类的名称，通过反射机制完成创建对象；
 * 通过类的名称，完成创建对象（反射完成！） 返回具体的Dao实现类对象
 */
public class DaoFactory {
	
	private static final DaoFactory factory = new DaoFactory();
	private DaoFactory(){}
	
	public static DaoFactory getInstance(){
		return factory;
	}
	public <T> T createDao(String className, Class<T> clazz){
		try{
			T t = (T) Class.forName(className).newInstance();
			return t;
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
