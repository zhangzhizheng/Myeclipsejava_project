package cn.my.service;
/**
 * 自定义异常类就是给出父类的构造器即可，方便来创建对象!
 * @author Administrator
 *
 */
public class UserException extends Exception {

	public UserException() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public UserException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public UserException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	

}
